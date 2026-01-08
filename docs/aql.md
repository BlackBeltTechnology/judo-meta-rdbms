# Acceleo Query Language (AQL) Reference

> Source: [Eclipse Acceleo Documentation](https://eclipse.dev/acceleo/documentation/)

## Overview

AQL (Acceleo Query Language) is a compact, efficient language designed to navigate and query EMF models. It is used in Sirius odesign files for defining diagram behavior, validations, and UI logic.

**Key Features:**
- Small, simple, fast, and extensible
- Static and dynamic Ecore model support without compilation
- Strong type validation with inference mechanisms
- Union type support for handling multiple potential types
- Extensibility through Java service classes
- Graceful null handling (null values don't cause failures)

## Syntax Fundamentals

### Basic Concepts

- Expressions begin with variable references
- The reserved variable `self` represents the current object instance
- Feature access uses the dot (`.`) separator
- Collection operations use the arrow (`->`) operator

### Navigation Patterns

**Feature Access:**
```
self.name           # Access attribute
self.father         # Access reference
```

**Collection Behavior:**
```
self.parents        # Returns a collection (multi-valued attribute)
self.parents.name   # Applies to each element implicitly
self.parents.name->size()  # Operates on collection itself
```

**Collection Filtering:**
```
->filter(type)      # Keep elements matching specified type
->select(condition) # Retain elements satisfying predicate
```

### Variable Binding

```
let container = self.eContainer() in container.eAllContents()
```

### Conditional Expressions

AQL's `if` must be an expression with a required `else` clause:

```
if self.name.startsWith('a') then self else self.eContainer() endif
```

## Collection Types

AQL supports two collection types:

| Type | Description |
|------|-------------|
| **Sequence** | Ordered list allowing duplicates |
| **OrderedSet** | Ordered collection excluding duplicates |

**Creation Syntax:**
```
OrderedSet{self}                    # Set containing current object
Sequence{self, self.eContainer()}   # Sequence with multiple elements
```

**Conversion:**
```
self.members->asSet()       # Convert to set
self.members->asSequence()  # Convert to sequence
```

## Operators

### Arithmetic Operators

| Operator | Description |
|----------|-------------|
| `+` | Addition / String concatenation |
| `-` | Subtraction / Unary negation |
| `*` | Multiplication |
| `/` | Division |

### Comparison Operators

| Operator | Description |
|----------|-------------|
| `=` | Equality |
| `<>` or `!=` | Inequality |
| `<` | Less than |
| `>` | Greater than |
| `<=` | Less than or equal |
| `>=` | Greater than or equal |

### Logical Operators

| Operator | Description |
|----------|-------------|
| `and` | Logical AND |
| `or` | Logical OR |
| `xor` | Logical XOR |
| `implies` | Logical implication |
| `not` | Logical negation |

## Type Literals

Types reference EPackage-qualified names:

```
ecore::EPackage                      # Specific type
ecore::EClass                        # Another type
{ecore::EPackage | ecore::EClass}    # Type union
uml::VisibilityKind::private         # Enumeration literal
```

## Services Reference

### Object Services (Universal)

| Service | Signature | Description |
|---------|-----------|-------------|
| `=` | `Object = Object : Boolean` | Test equivalence |
| `<>` | `Object <> Object : Boolean` | Test inequality |
| `oclAsType` | `oclAsType(Type) : Type` | Type casting |
| `oclIsKindOf` | `oclIsKindOf(Type) : Boolean` | Test type conformance (including subtypes) |
| `oclIsTypeOf` | `oclIsTypeOf(Type) : Boolean` | Test exact type match |
| `toString` | `toString() : String` | String representation |

### Boolean Services

| Service | Description |
|---------|-------------|
| `and(Boolean)` | Logical AND |
| `or(Boolean)` | Logical OR |
| `xor(Boolean)` | Logical XOR |
| `implies(Boolean)` | Logical implication |
| `not()` | Logical negation |

### String Services

**Content Checking:**

| Service | Description |
|---------|-------------|
| `contains(String)` | Check if string contains substring |
| `startsWith(String)` | Check prefix |
| `endsWith(String)` | Check suffix |
| `matches(String)` | Test against regex pattern |

**Manipulation:**

| Service | Description |
|---------|-------------|
| `concat(String)` | Concatenate strings |
| `substring(Integer, Integer)` | Extract substring |
| `replace(regex, replacement)` | Replace pattern |
| `toLower()` | Convert to lowercase |
| `toUpper()` | Convert to uppercase |
| `trim()` | Remove leading/trailing whitespace |
| `tokenize(delimiter)` | Split string by delimiter |

**Conversion:**

| Service | Description |
|---------|-------------|
| `size()` | Return character count |
| `toInteger()` | Convert to integer |
| `toReal()` | Convert to decimal |

### Numeric Services

| Service | Description |
|---------|-------------|
| `abs()` | Absolute value |
| `floor()` | Round down |
| `ceil()` | Round up |
| `round()` | Round to nearest |
| `max(Number)` | Maximum of two numbers |
| `min(Number)` | Minimum of two numbers |

### Collection Services

**Element Access:**

| Service | Description |
|---------|-------------|
| `->first()` | Return first element |
| `->last()` | Return last element |
| `->at(Integer)` | Return element at position (1-based) |
| `->indexOf(Object)` | Find position of element |

**Filtering & Selection:**

| Service | Description |
|---------|-------------|
| `->select(x \| condition)` | Keep elements matching condition |
| `->reject(x \| condition)` | Remove elements matching condition |
| `->filter(Type)` | Keep elements of specified type |
| `->any(x \| condition)` | Return first matching element |

**Transformation:**

| Service | Description |
|---------|-------------|
| `->collect(x \| expression)` | Apply expression to each element |
| `->sortedBy(x \| expression)` | Sort by expression result |
| `->reverse()` | Reverse order |

**Testing:**

| Service | Description |
|---------|-------------|
| `->exists(x \| condition)` | True if any element matches |
| `->forAll(x \| condition)` | True if all elements match |
| `->one(x \| condition)` | True if exactly one matches |
| `->includes(Object)` | True if collection contains element |
| `->excludes(Object)` | True if collection doesn't contain element |
| `->isEmpty()` | True if collection is empty |
| `->notEmpty()` | True if collection is not empty |

**Manipulation:**

| Service | Description |
|---------|-------------|
| `->including(Object)` | Return collection with element added |
| `->excluding(Object)` | Return collection with element removed |
| `->prepend(Object)` | Add element at beginning |
| `->append(Object)` | Add element at end |

**Set Operations:**

| Service | Description |
|---------|-------------|
| `->union(Collection)` | Combine collections |
| `->intersection(Collection)` | Return common elements |
| `->sub(Collection)` | Remove elements in second collection |
| `->concat(Collection)` | Concatenate collections |

**Conversion:**

| Service | Description |
|---------|-------------|
| `->asSet()` | Convert to OrderedSet |
| `->asSequence()` | Convert to Sequence |
| `->asOrderedSet()` | Convert to OrderedSet |

**Size:**

| Service | Description |
|---------|-------------|
| `->size()` | Return element count |

### EObject Navigation Services

**Containment:**

| Service | Description |
|---------|-------------|
| `eContainer()` | Return parent element |
| `eContainer(Type)` | Return first parent matching type |
| `eContainerOrSelf(Type)` | Return self or matching parent |
| `eContents()` | Return direct children |
| `eContents(Type)` | Return direct children of type |
| `eAllContents()` | Return all descendants |
| `eAllContents(Type)` | Return all descendants of type |

**Type Information:**

| Service | Description |
|---------|-------------|
| `eClass()` | Return element's EClass |

**References:**

| Service | Description |
|---------|-------------|
| `eInverse()` | Return all objects referencing this one |
| `eInverse(reference)` | Return objects via specific reference |
| `eCrossReferences()` | Return all external references |

**Features:**

| Service | Description |
|---------|-------------|
| `eContainingFeature()` | Return the containing reference |
| `eContainmentFeature()` | Return the containment reference |

## Common AQL Patterns

### Model Navigation

```aql
self.eContainer()                    # Get parent
self.eAllContents()                  # Get all descendants
self.getModel()                      # Get root model (custom service)
self.getAllInstancesOf(Type)         # Get all instances (custom service)
```

### Type Checking

```aql
self.oclIsTypeOf(structure::EntityType)      # Exact type check
self.oclIsKindOf(namespace::NamespaceElement) # Type or subtype
self.oclAsType(structure::TransferObjectType) # Cast to type
```

### Collection Processing

```aql
elements->select(e | e.name.startsWith('A'))  # Filter by condition
elements->collect(e | e.name)                 # Extract names
elements->sortedBy(e | e.name)                # Sort alphabetically
elements->exists(e | e.abstract)              # Check if any abstract
elements->forAll(e | e.name <> null)          # Check all have names
```

### String Operations

```aql
self.name.toLower()                           # Lowercase
self.name.substring(0, 3)                     # First 3 characters
self.name.replace('Entity', 'Transfer')       # Replace text
self.name.size() > 0                          # Check not empty
```

### Conditional Logic

```aql
if self.abstract then 'Abstract' else 'Concrete' endif
if self.name <> null then self.name else 'unnamed' endif
```

## Usage in Sirius Odesign

AQL expressions in odesign files are prefixed with `aql:`:

```xml
labelExpression="aql:self.name"
preconditionExpression="aql:self.oclIsKindOf(structure::EntityType)"
candidatesExpression="aql:self.eAllContents(namespace::Package)"
```

### Common Expression Attributes

| Attribute | Purpose |
|-----------|---------|
| `labelExpression` | Display labels |
| `preconditionExpression` | Enable/show conditions |
| `predicateExpression` | Boolean conditions |
| `valueExpression` | Property values |
| `candidatesExpression` | Dropdown candidates |
| `semanticCandidatesExpression` | Semantic element candidates |
| `browseExpression` | Navigation expressions |
| `conditionExpression` | Conditional logic |
| `targetFinderExpression` | Find target elements |
| `sourceFinderExpression` | Find source elements |

## Calling Java Services

AQL can call Java service methods defined in service classes. The mapping convention:

| AQL Expression | Java Method |
|----------------|-------------|
| `self.methodName()` | `Services.methodName(self)` |
| `self.methodName(arg)` | `Services.methodName(self, arg)` |

The first parameter in Java corresponds to `self` in AQL.

**Example:**
```xml
valueExpression="aql:container.createAttribute()"
```
Calls:
```java
public static DataMember createAttribute(TransferObjectType self)
```

## Migration Notes

### Key Differences from MTL/Acceleo 3

1. **Explicit variable references**: Use `self.feature` instead of implicit access
2. **Lambda parameters**: Require explicit naming: `collect(m | m.eAllContents())`
3. **Collection types**: Only Sequence and OrderedSet (no Set, Bag)
4. **Null handling**: Null values handled gracefully, don't propagate errors
5. **No oclIsUndefined()**: Use `... <> null` instead

### Renamed Operations

| Old (MTL) | New (AQL) |
|-----------|-----------|
| `addAll()` | `add()` / `union()` |
| `removeAll()` | `sub()` |
