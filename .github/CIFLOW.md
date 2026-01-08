# Development version and branch handling

## Table of Contents
- [Branches](#branches)
- [Version numbers](#version-numbers)
- [GitHub action flows](#github-action-flows)
- [How to develop](#how-to-develop)

## Branches

Versioning policy of JUDO NG modules are based on GitFlow: https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow.

Branches:

* **develop**: development branch contains latest development sources of the last active version
* **feature/JNG-NUMBER_short_summary**: feature branches are based on **develop** and contains sources of new features that will be included in last active version
* **(release/)1_0_beta1**: release branches of 1.0-beta1 (release/ prefix is still reserved for CI)
* **bugfix/JNG-NUMBER_short_summary**, **support/JNG-NUMBER_short_summary**: bugfix and support branches are based on release branches and must be applied to release and development branches of newer versions too
* **master**: contains latest released sources of the last active version

### Branch Flow Diagram

```mermaid
gitGraph
   commit id: "initial"
   branch develop
   checkout develop
   commit id: "dev-1"
   branch feature/JNG-1
   checkout feature/JNG-1
   commit id: "feat-1"
   commit id: "feat-2"
   checkout develop
   branch feature/JNG-2
   checkout feature/JNG-2
   commit id: "feat-3"
   checkout develop
   merge feature/JNG-2
   checkout feature/JNG-1
   commit id: "feat-4"
   checkout develop
   merge feature/JNG-1
   branch release/1.0-beta1
   checkout release/1.0-beta1
   commit id: "rel-1"
   branch bugfix/JNG-4
   checkout bugfix/JNG-4
   commit id: "bug-1"
   checkout release/1.0-beta1
   merge bugfix/JNG-4
   checkout develop
   merge release/1.0-beta1
   checkout main
   merge release/1.0-beta1 tag: "v1.0-beta1"
```

## Version numbers

Version numbers are increased using semantic versioning:

* do not change version numbers on starting feature/ branches
* 2nd number in version of **develop** branch is increased when a release branch started
* do not change version numbers on bugfix/ branches - that are applied on release branches during testing before releasing it (merging to master)
* 3rd number in version of support/ branches is increased when started - it is used to support a previous release including new (minor) changes; support/ branches are merged back to release branch when update is released (without merging changes to master)
* 4th number in version of hotfix/ branches is increased when started (that are applied on both release and master branches)

## GitHub action flows

### build.yml

**Trigger:** push on **develop** branch or pull request on **develop**, **master**, **increment/\***, **release/\*** branch

```mermaid
flowchart TD
    A[/"<b>when</b><br/>push on <b>develop</b> branch<br/>or<br/>pull request on <b>develop</b>, <b>master</b>,<br/><b>increment/*</b>, <b>release/*</b> branch"/]
    A --> B{Commit or PR base branch?}
    B -->|master, release/*| C["Set <b>version</b><br/>from project pom.xml<br/>(version without '-SNAPSHOT')"]
    B -->|develop, increment/*| D["Set version<br/><b>major.minor.qualifier.date_commitId_branchName</b><br/>from project pom.xml"]
    C --> E[Build and deploy to nexus]
    D --> E
    E --> F["Create git tag <b>v&lt;version&gt;</b>"]
    F --> G{PR or commit base branch?}
    G -->|increment/*, release/*| H["Create tag <b>merge-pr/&lt;version&gt;</b>"]
    H --> I[/"<b>trigger merge-pr-tagged.yml</b>"/]
    G -->|develop| J[Build change log]
    J --> K["Create <b>github release</b><br/>(prerelease) with change log"]
    G -->|other| L([End])
    I --> L
    K --> L
```

### merge-pr-tagged.yml

**Trigger:** push on **merge-pr/\*** tag

```mermaid
flowchart TD
    A[/"<b>when</b><br/>push on <b>merge-pr/*</b> tag"/]
    A --> B["Get &lt;version&gt; from tag name"]
    B --> C{"Check &lt;version&gt; format"}
    C -->|major.minor.qualifier| D["Merge pull request to <b>master</b>"]
    D --> E[/"<b>trigger create-release-on-master.yml</b>"/]
    C -->|other| F["Squash pull request to <b>develop</b>"]
    F --> G[/"<b>trigger build.yml</b>"/]
    E --> H["Delete tag <b>merge-pr/&lt;version&gt;</b>"]
    G --> H
    H --> I([End])
```

### create-release-on-master.yml

**Trigger:** push on **master** branch

```mermaid
flowchart TD
    A[/"<b>when</b><br/>push on <b>master</b> branch"/]
    A --> B["Get &lt;version&gt; from tag name"]
    B --> C[Build change log]
    C --> D["Create <b>github release</b><br/>(last) with change log"]
    D --> E([End])
```

### release.yml

**Trigger:** manually triggered with **given version** which is **'auto'** or any other in **major.minor.qualifier** form

```mermaid
flowchart TD
    A[/"<b>when</b><br/>manually triggered with <b>given version</b><br/>which is <b>'auto'</b> or any other<br/>in <b>major.minor.qualifier</b> form"/]
    A --> B{"given version is"}
    B -->|'auto'| C["Set <b>release version</b><br/>from project pom.xml<br/>(version without '-SNAPSHOT')"]
    B -->|other| D["Set <b>release version</b><br/>to given version"]
    C --> E["Set <b>next version</b> to<br/>release version's qualifier + 1"]
    D --> E
    E --> F["Create pull request on <b>master</b><br/>with <b>release version</b>"]
    F --> G[/"<b>trigger build.yml</b>"/]
    E --> H["Create pull request on <b>develop</b><br/>with <b>next version</b>"]
    H --> I[/"<b>trigger build.yml</b>"/]
    G --> J([End])
    I --> J
```

## How to develop

For issue tracking we are using [JIRA](https://blackbelt.atlassian.net/jira/dashboards). Golden rule:

> **IMPORTANT:** *There is no commit without ticket number*

So for pull request or commit `JNG-xxx` have to be presented in the commit.
