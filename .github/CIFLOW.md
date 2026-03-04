# Development Version and Branch Handling

## Branches

The JUDO NG versioning policy is based on [GitFlow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow). Each branch type serves a specific purpose in the development lifecycle:

| Branch Pattern | Purpose | Based On |
|---------------|---------|----------|
| `develop` | Latest development sources of the active version | — |
| `feature/JNG-NUMBER_summary` | New features for the active version | `develop` |
| `(release/)X.Y.Z` | Release candidate stabilization | `develop` |
| `bugfix/JNG-NUMBER_summary` | Fixes applied during release testing | release branch |
| `support/JNG-NUMBER_summary` | Minor updates to a previous release | release branch |
| `master` | Latest released sources | merged from release |
| `hotfix/JNG-NUMBER_summary` | Emergency fixes to production | `master` |

> **Note:** Bugfix and support branch changes must be applied to both the release branch and newer development branches.

```mermaid
gitGraph
    commit id: "init"
    branch develop
    checkout develop
    commit id: "dev-1"
    branch feature/JNG-1
    commit id: "feat-1"
    commit id: "feat-2"
    checkout develop
    merge feature/JNG-1 id: "merge-feat-1"
    branch feature/JNG-3
    commit id: "feat-3"
    checkout develop
    merge feature/JNG-3 id: "merge-feat-3"
    branch release/1.0-beta1
    commit id: "rc-1"
    branch bugfix/JNG-4
    commit id: "fix-1"
    checkout release/1.0-beta1
    merge bugfix/JNG-4 id: "merge-fix"
    checkout develop
    merge release/1.0-beta1 id: "merge-release"
    checkout master
    merge release/1.0-beta1 id: "v1.0"
```

## Version Numbers

Version numbers follow semantic versioning with these rules:

| Event | Version Change |
|-------|---------------|
| Starting a `feature/` branch | No change |
| Starting a release branch from `develop` | 2nd number incremented on `develop` |
| Starting a `bugfix/` branch | No change (applied on release branches before merge to master) |
| Starting a `support/` branch | 3rd number incremented |
| Starting a `hotfix/` branch | 4th number incremented |

## GitHub Actions Workflows

The CI/CD pipeline consists of several interconnected workflows:

### build.yml — Main Build Pipeline

Triggered on push to `develop` or pull requests targeting `develop`, `master`, `increment/*`, or `release/*` branches.

```mermaid
flowchart TD
    TRIGGER["Push on develop<br/>or PR on develop/master/increment/release"]
    TRIGGER --> BRANCH_CHECK{"Base branch?"}

    BRANCH_CHECK -->|"master, release/*"| VER_RELEASE["Set version from pom.xml<br/>(without -SNAPSHOT)"]
    BRANCH_CHECK -->|"develop, increment/*"| VER_DEV["Set version:<br/>major.minor.qualifier.date_commitId_branch"]

    VER_RELEASE --> BUILD["Build and deploy to Nexus"]
    VER_DEV --> BUILD

    BUILD --> TAG["Create git tag v&lt;version&gt;"]

    TAG --> PR_CHECK{"PR or commit<br/>base branch?"}
    PR_CHECK -->|"increment/*, release/*"| MERGE_TAG["Create tag merge-pr/&lt;version&gt;"]
    MERGE_TAG --> TRIGGER_MERGE["Trigger merge-pr-tagged.yml"]

    PR_CHECK -->|"develop"| CHANGELOG["Build change log"]
    CHANGELOG --> GH_RELEASE["Create GitHub release<br/>(prerelease)"]
```

### merge-pr-tagged.yml — Post-Merge Handler

Triggered when a `merge-pr/*` tag is pushed. Determines whether to merge to `master` (for release versions) or squash to `develop`.

```mermaid
flowchart TD
    TRIGGER["Push on merge-pr/* tag"]
    TRIGGER --> GET_VER["Extract version from tag name"]
    GET_VER --> FORMAT_CHECK{"Version format?"}

    FORMAT_CHECK -->|"major.minor.qualifier"| MERGE_MASTER["Merge PR to master"]
    MERGE_MASTER --> TRIGGER_RELEASE["Trigger create-release-on-master.yml"]

    FORMAT_CHECK -->|"other format"| SQUASH_DEV["Squash PR to develop"]
    SQUASH_DEV --> TRIGGER_BUILD["Trigger build.yml"]

    MERGE_MASTER --> DELETE_TAG["Delete merge-pr/ tag"]
    SQUASH_DEV --> DELETE_TAG
```

### create-release-on-master.yml — Release Creation

Triggered on push to `master`. Creates a GitHub release with a generated changelog.

```mermaid
flowchart LR
    PUSH["Push on master"] --> VERSION["Get version from tag"]
    VERSION --> CHANGELOG["Build change log"]
    CHANGELOG --> RELEASE["Create GitHub release (latest)"]
```

### release.yml — Manual Release Pipeline

Manually triggered with a version parameter (either `'auto'` or a specific `major.minor.qualifier`).

```mermaid
flowchart TD
    TRIGGER["Manual trigger with version"]
    TRIGGER --> CHECK{"Given version?"}

    CHECK -->|"'auto'"| AUTO["Release version =<br/>pom.xml version without -SNAPSHOT"]
    CHECK -->|"specific"| SPECIFIC["Release version =<br/>given version"]

    AUTO --> NEXT["Next version =<br/>release qualifier + 1"]
    SPECIFIC --> NEXT

    NEXT --> PR_MASTER["Create PR on master<br/>with release version"]
    NEXT --> PR_DEVELOP["Create PR on develop<br/>with next version"]

    PR_MASTER --> BUILD1["Trigger build.yml"]
    PR_DEVELOP --> BUILD2["Trigger build.yml"]
```

## Development Rules

> **Important:** There is no commit without a ticket number. Every pull request and commit must include a JIRA ticket reference in the format `JNG-xxx`.

Issue tracking is managed via [JIRA](https://blackbelt.atlassian.net/jira/dashboards).
