# Zeta Validation Skill

This skill helps create and describe proper validation rules and tests for the ESM (Entity Service Model) Java validation framework.

## Overview

The ESM validation framework provides annotation-based validation rules that mirror EVL (Epsilon Validation Language) semantics. Use this skill to:
- Create new validation rule classes
- Write constraint and critique methods
- Implement guard conditions
- Set up constraint dependencies with `@Satisfies`
- Write corresponding unit tests

## Validation Rule Structure

### Package Organization

```
hu.blackbelt.judo.meta.esm.validation/
├── rules/
│   ├── namespace/     # NamedElement, Model validations
│   ├── structure/     # EntityType, DataMember, Relations
│   ├── type/          # Cardinality, Enumerations, Primitives
│   ├── measure/       # Measures, Units, DurationUnits
│   ├── operation/     # Operations, Parameters
│   ├── accesspoint/   # ActorType, Access
│   └── ui/            # Widgets, Forms, Tables, Actions
```

### Validation Class Template

```java
package hu.blackbelt.judo.meta.esm.validation.rules.<category>;

import hu.blackbelt.judo.meta.esm.<package>.<EClass>;
import hu.blackbelt.judo.meta.esm.validation.annotation.*;
import hu.blackbelt.judo.meta.esm.validation.core.*;
import org.eclipse.emf.ecore.EObject;

/**
 * Validation rules for <EClass>.
 * 
 * Source EVL: validations/<category>/<eclass>.evl
 */
@ValidationContext(<EClass>.class)
public class <EClass>Validations {

    // ==================== Guard Methods ====================

    public boolean hasContainer(EObject element, ValidationContext ctx) {
        return element.eContainer() != null;
    }

    // ==================== Constraints (Errors) ====================

    @Constraint(
        name = "<ConstraintName>",
        message = "<Error message with {element.name} placeholders>"
    )
    @Guard(method = "<guardMethodName>")
    @Satisfies(constraints = {"<DependencyConstraint1>", "<DependencyConstraint2>"})
    public ValidationRule <constraintMethodName>() {
        return (element, ctx) -> {
            <EClass> self = (<EClass>) element;
            
            // Validation logic
            if (<failureCondition>) {
                return ValidationResult.fail("<detailed error message>");
            }
            
            return ValidationResult.pass();
        };
    }

    // ==================== Critiques (Warnings) ====================

    @Critique(
        name = "<CritiqueName>",
        message = "<Warning message>"
    )
    public ValidationRule <critiqueMethodName>() {
        return (element, ctx) -> {
            <EClass> self = (<EClass>) element;
            
            // Validation logic
            return <warningCondition>
                ? ValidationResult.warn("<warning message>")
                : ValidationResult.pass();
        };
    }
}
```

## Annotations Reference

| Annotation | Level | Purpose |
|------------|-------|---------|
| `@ValidationContext(EClass.class)` | Class | Declares target EClass for all rules |
| `@Constraint(name, message)` | Method | Error-level rule (must fix) |
| `@Critique(name, message)` | Method | Warning-level rule (recommendation) |
| `@Guard(method = "methodName")` | Method | Conditional execution predicate |
| `@Satisfies(constraints = {...})` | Method | Constraint dependencies |
| `@Cached` | Method | Cache extension method results |

## Common Patterns

### Using ValidationContext

```java
// Get all instances of a type
ctx.getAllInstances(EntityType.class)

// Check if constraint is satisfied
ctx.satisfies("NamedElementHasContainer")

// Get EsmUtils helper
ctx.getEsmUtils().getAllSuperTypes(self)
```

### Stream Operations (EOL to Java)

| EOL | Java |
|-----|------|
| `collection.exists(x \| cond)` | `stream().anyMatch(x -> cond)` |
| `collection.forAll(x \| cond)` | `stream().allMatch(x -> cond)` |
| `collection.select(x \| cond)` | `stream().filter(x -> cond).collect(toList())` |
| `collection.collect(x \| x.prop)` | `stream().map(x -> x.getProp()).collect(toList())` |
| `collection.excluding(self)` | `stream().filter(x -> x != self)` |

### Guard Method Signature

```java
public boolean <methodName>(EObject element, ValidationContext ctx) {
    <EClass> self = (<EClass>) element;
    return <condition>;
}
```

## Test Structure

### Test Class Template

```java
package hu.blackbelt.judo.meta.esm;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static hu.blackbelt.judo.meta.esm.structure.util.builder.StructureBuilders.*;

class EsmValidation<Category>Test extends AbstractEsmValidationTest {

    @ParameterizedTest
    @EnumSource(ValidatorType.class)
    void test<ConstraintName>(ValidatorType validatorType) throws Exception {
        // Arrange: Create model elements that violate the constraint
        <EClass> element = new<EClass>Builder()
            .withName("<name>")
            // ... other properties
            .build();

        Model m = newModelBuilder()
            .withName("M")
            .withElements(ImmutableList.of(element))
            .build();

        esmModel.addContent(m);

        // Act & Assert: Run validation expecting the error
        runValidation(
            validatorType,
            ImmutableList.of("<ConstraintName>"),  // Expected errors
            ImmutableList.of()                      // Expected warnings
        );
    }

    @ParameterizedTest
    @EnumSource(ValidatorType.class)
    void test<CritiqueName>(ValidatorType validatorType) throws Exception {
        // Arrange: Create model elements that trigger the warning
        // ...

        // Act & Assert
        runValidation(
            validatorType,
            ImmutableList.of(),                     // Expected errors
            ImmutableList.of("<CritiqueName>")      // Expected warnings
        );
    }
}
```

### AbstractEsmValidationTest Base

The base class provides:
- `esmModel` - The ESM model instance
- `runValidation(validatorType, expectedErrors, expectedWarnings)` - Runs EVL or Java validation
- Builder imports for all ESM types

## Example: Creating a New Validation

### 1. Identify the EVL Rule

```evl
context ESM!EntityType {
    constraint EntityTypeMustHaveAtLeastOneAttribute {
        guard: self.satisfies("NamedElementHasContainer")
        check: self.attributes.size() > 0
        message: "Entity type " + self.name + " must have at least one attribute"
    }
}
```

### 2. Create Java Validation

```java
@ValidationContext(EntityType.class)
public class EntityTypeValidations {

    @Constraint(
        name = "EntityTypeMustHaveAtLeastOneAttribute",
        message = "Entity type must have at least one attribute"
    )
    @Satisfies(constraints = "NamedElementHasContainer")
    public ValidationRule entityTypeMustHaveAtLeastOneAttribute() {
        return (element, ctx) -> {
            EntityType self = (EntityType) element;
            
            if (self.getAttributes().isEmpty()) {
                return ValidationResult.fail(
                    "Entity type " + self.getName() + " must have at least one attribute"
                );
            }
            
            return ValidationResult.pass();
        };
    }
}
```

### 3. Write Test

```java
@ParameterizedTest
@EnumSource(ValidatorType.class)
void testEntityTypeMustHaveAtLeastOneAttribute(ValidatorType validatorType) throws Exception {
    EntityType entityType = newEntityTypeBuilder()
        .withName("EmptyEntity")
        .withMapping(newMappingBuilder().build())
        // No attributes added
        .build();
    entityType.getMapping().setTarget(entityType);

    Model m = newModelBuilder()
        .withName("M")
        .withElements(ImmutableList.of(entityType))
        .build();

    esmModel.addContent(m);

    runValidation(
        validatorType,
        ImmutableList.of("EntityTypeMustHaveAtLeastOneAttribute"),
        ImmutableList.of("AtLeastOneActorIsDefined")
    );
}
```

## Documentation Links

- [Validation README](docs/validation/README.md) - Overview and categories
- [Java Framework](docs/validation/java-validation-framework.md) - Complete framework reference
- [Judo Zeta Framework](https://github.com/BlackBeltTechnology/judo-zeta) - Main repository
- [Zeta Validation Guide](https://github.com/BlackBeltTechnology/judo-zeta/blob/develop/docs/validation/index.md)

## Checklist for New Validations

- [ ] Identify source EVL constraint/critique
- [ ] Create or update validation class in appropriate package
- [ ] Add `@ValidationContext` annotation
- [ ] Implement constraint/critique method with proper annotations
- [ ] Add guard method if needed
- [ ] Add `@Satisfies` for dependencies
- [ ] Write parameterized test with `@EnumSource(ValidatorType.class)`
- [ ] Test both passing and failing cases
- [ ] Update documentation if adding new category
