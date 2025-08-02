# 📘 TypeScript Guide

**TypeScript** is a superset of JavaScript that adds **static typing**. It helps catch errors during development and makes your code more **robust** and **easier to understand**.

---

## ✨ Prerequisites

- Install **Node.js** (version **22.x LTS** or higher) from [https://nodejs.org](https://nodejs.org)

---

## 📆 Install TypeScript

```bash
npm install -g typescript
```

---

## 🔍 Check TypeScript Version

```bash
tsc --version
```

---

## ⚙️ Compile TypeScript File

```bash
tsc fileName.ts
```

This will generate a corresponding `fileName.js` file in the same directory.

---

## ⚙️ Interprets JavaScript File

```bash
node fileName.js
```

# TypeScript Tutorial

TypeScript is typed JavaScript, adding types to JavaScript to catch errors early, before running the code. It’s an open-source programming language that builds on JavaScript, working in any browser, OS, or environment where JavaScript runs.

In this tutorial, you’ll learn:

- Why TypeScript offers significant benefits over vanilla JavaScript.
- How TypeScript works under the hood.
- How to use TypeScript features like Types, Classes, Interfaces, Modules, and more.

## Prerequisites

To follow this tutorial, you need:

- Basic JavaScript knowledge (see JavaScript Tutorial if needed).
- Familiarity with ECMAScript 2015 (ES6).

## Section 1. Getting Started

### What is TypeScript

TypeScript is a superset of JavaScript that adds static typing to catch errors during development. It compiles to plain JavaScript, ensuring compatibility with any JavaScript environment. Benefits include:

- Early error detection via type checking.
- Improved code readability and maintainability.
- Enhanced tooling with autocompletion and refactoring support.

### Setting up the TypeScript Development Environment

To start using TypeScript:

1. Install Node.js from nodejs.org.
2. Install TypeScript globally via npm:

   ```bash
   npm install -g typescript
   ```
3. Verify the installation:

   ```bash
   tsc --v
   ```

   This displays the TypeScript compiler (tsc) version.

### TypeScript Hello World

Create your first TypeScript program:

1. Create a file named `hello.ts`:

   ```typescript
   function greet(name: string) {
       return `Hello, ${name}!`;
   }
   console.log(greet("World"));
   ```
2. Compile it to JavaScript:

   ```bash
   tsc hello.ts
   ```
3. Run the generated `hello.js` file:

   ```bash
   node hello.js
   ```

   Output: `Hello, World!`

### Why TypeScript

TypeScript enhances JavaScript by:

- Catching type-related errors at compile time.
- Providing better IDE support for code navigation and refactoring.
- Enabling large-scale application development with maintainable code.

## Section 2. Basic Types

### Type Annotation

Type annotations define the type of variables, function parameters, or return values:

```typescript
let age: number = 25;
function greet(name: string): string {
    return `Hello, ${name}`;
}
```

### Type Inference

TypeScript infers types when not explicitly defined:

```typescript
let count = 10; // TypeScript infers `number`
count = "string"; // Error: Type 'string' is not assignable to type 'number'
```

### Number

TypeScript supports all JavaScript numeric types, including:

- Floating-point numbers: `let price: number = 19.99;`
- Big integers: `let big: bigint = 9007199254740991n;`

### String

The string type handles text:

```typescript
let greeting: string = "Hello, TypeScript!";
```

### Boolean

The boolean type represents `true` or `false`:

```typescript
let isActive: boolean = true;
```

### Object Type

The object type represents non-primitive values:

```typescript
let person: { name: string, age: number } = { name: "Alice", age: 30 };
```

### Array

Arrays store multiple values of the same type:

```typescript
let numbers: number[] = [1, 2, 3];
let strings: Array<string> = ["a", "b", "c"];
```

### Tuple

Tuples store a fixed number of elements with specific types:

```typescript
let tuple: [string, number] = ["Alice", 25];
```

### Enum

Enums define a set of named constants:

```typescript
enum Color {
    Red,
    Green,
    Blue
}
let c: Color = Color.Green; // 1
```

### Any Type

The `any` type allows any value, bypassing type checking:

```typescript
let value: any = 42;
value = "string"; // No error
```

### Unknown Type

The `unknown` type is safer than `any`, requiring type checking:

```typescript
let value: unknown = 42;
if (typeof value === "string") {
    console.log(value.toUpperCase()); // Type-safe
}
```

### Void Type

The `void` type is used for functions that return nothing:

```typescript
function logMessage(): void {
    console.log("No return value");
}
```

### Never Type

The `never` type represents values that never occur:

```typescript
function throwError(): never {
    throw new Error("Error");
}
```

### Union Types

Union types allow a variable to hold one of several types:

```typescript
let id: string | number = "123";
id = 123; // Valid
```

### String Literal Types

String literal types restrict a variable to specific string values:

```typescript
let direction: "up" | "down" = "up";
```

### Type Aliases

Type aliases create reusable type definitions:

```typescript
type Point = { x: number, y: number };
let p: Point = { x: 10, y: 20 };
```

## Section 3. Control Flow Statements

### if…else

Execute code based on conditions:

```typescript
let num: number = 10;
if (num > 0) {
    console.log("Positive");
} else {
    console.log("Non-positive");
}
```

### switch…case

Handle multiple conditions:

```typescript
let day: number = 2;
switch (day) {
    case 1:
        console.log("Monday");
        break;
    case 2:
        console.log("Tuesday");
        break;
    default:
        console.log("Other");
}
```

### for

Loop a specified number of times:

```typescript
for (let i: number = 0; i < 5; i++) {
    console.log(i);
}
```

### while

Loop while a condition is true:

```typescript
let i: number = 0;
while (i < 5) {
    console.log(i);
    i++;
}
```

### do…while

Execute at least once, then loop while a condition is true:

```typescript
let i: number = 0;
do {
    console.log(i);
    i++;
} while (i < 5);
```

### break

Exit a loop or switch:

```typescript
for (let i: number = 0; i < 10; i++) {
    if (i === 5) break;
    console.log(i);
}
```

### continue

Skip to the next iteration:

```typescript
for (let i: number = 0; i < 5; i++) {
    if (i % 2 === 0) continue;
    console.log(i); // Prints odd numbers
}
```

## Section 4. Functions

### Functions

Declare functions with type annotations:

```typescript
function add(a: number, b: number): number {
    return a + b;
}
```

### Function Types

Define types for functions:

```typescript
let calculate: (x: number, y: number) => number;
calculate = add;
```

### Optional Parameters

Make parameters optional with `?`:

```typescript
function greet(name: string, greeting?: string): string {
    return `${greeting || "Hello"}, ${name}`;
}
```

### Default Parameters

Provide default values for parameters:

```typescript
function greet(name: string, greeting: string = "Hello"): string {
    return `${greeting}, ${name}`;
}
```

### Rest Parameters

Handle variable number of arguments:

```typescript
function sum(...numbers: number[]): number {
    return numbers.reduce((total, num) => total + num, 0);
}
```

### Function Overloadings

Define multiple function signatures:

```typescript
function combine(a: number, b: number): number;
function combine(a: string, b: string): string;
function combine(a: any, b: any): any {
    return a + b;
}
```

## Section 5. Classes

### Classes

Define classes with typed properties and methods:

```typescript
class Person {
    name: string;
    age: number;
    constructor(name: string, age: number) {
        this.name = name;
        this.age = age;
    }
    greet(): string {
        return `Hello, ${this.name}`;
    }
}
```

### Access Modifiers

Use `public`, `private`, and `protected`:

```typescript
class Employee {
    private id: number;
    public name: string;
    protected salary: number;
    constructor(id: number, name: string, salary: number) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
```

### The readonly Modifier

Make properties immutable:

```typescript
class Product {
    readonly id: number;
    constructor(id: number) {
        this.id = id;
    }
}
```

### Getters & Setters

Control property access:

```typescript
class User {
    private _name: string;
    constructor(name: string) {
        this._name = name;
    }
    get name(): string {
        return this._name;
    }
    set name(value: string) {
        this._name = value;
    }
}
```

### Inheritance

Extend classes to reuse functionality:

```typescript
class Manager extends Employee {
    manage(): string {
        return `${this.name} is managing`;
    }
}
```

### Static Methods & Properties

Define class-level members:

```typescript
class Utility {
    static counter: number = 0;
    static increment(): void {
        Utility.counter++;
    }
}
```

### Abstract Classes

Define base classes with abstract methods:

```typescript
abstract class Shape {
    abstract getArea(): number;
}
class Circle extends Shape {
    radius: number;
    constructor(radius: number) {
        super();
        this.radius = radius;
    }
    getArea(): number {
        return Math.PI * this.radius ** 2;
    }
}
```

## Section 6. Interfaces

### Interfaces

Define contracts for objects:

```typescript
interface Person {
    name: string;
    age: number;
    greet(): string;
}
let user: Person = {
    name: "Alice",
    age: 30,
    greet() { return `Hello, ${this.name}`; }
};
```

### Extending Interfaces

Combine interfaces:

```typescript
interface Employee extends Person {
    employeeId: number;
}
```

### Interfaces vs. Abstract Classes

- Interfaces: Define contracts without implementation; support multiple inheritance.
- Abstract Classes: Can include implementation; only single inheritance.

## Section 7. Advanced Types

### Intersection Types

Combine multiple types:

```typescript
type A = { x: number };
type B = { y: number };
type C = A & B;
let obj: C = { x: 1, y: 2 };
```

### Type Guards

Narrow types in conditional blocks:

```typescript
function process(value: string | number) {
    if (typeof value === "string") {
        console.log(value.toUpperCase());
    } else {
        console.log(value.toFixed(2));
    }
}
```

### Type Assertions

Tell the compiler a variable’s type:

```typescript
let value: any = "hello";
let str: string = value as string;
```

## Section 8. Generics

### Introduction to TypeScript Generics

Create reusable components with generics:

```typescript
function identity<T>(value: T): T {
    return value;
}
let num = identity<number>(42);
let str = identity<string>("hello");
```

### Generic Constraints

Restrict generic types:

```typescript
function getLength<T extends { length: number }>(item: T): number {
    return item.length;
}
```

### Generic Classes

Define classes with generics:

```typescript
class Box<T> {
    content: T;
    constructor(value: T) {
        this.content = value;
    }
}
```

### Generic Interfaces

Define interfaces with generics:

```typescript
interface Pair<K, V> {
    key: K;
    value: V;
}
let pair: Pair<string, number> = { key: "id", value: 123 };
```

## Section 9. Modules

### TypeScript Modules

Organize code into modules:

```typescript
// math.ts
export function add(a: number, b: number): number {
    return a + b;
}

// main.ts
import { add } from "./math";
console.log(add(2, 3));
```

## Section 10. Setting up TypeScript Tools

### Node.js TypeScript

Set up TypeScript in a Node.js project:

1. Initialize a Node.js project:

   ```bash
   npm init -y
   ```
2. Install TypeScript and Node.js types:

   ```bash
   npm install typescript @types/node --save-dev
   ```
3. Create `tsconfig.json`:

   ```json
   {
       "compilerOptions": {
           "target": "es6",
           "module": "commonjs",
           "outDir": "./dist",
           "strict": true
       }
   }
   ```
4. Compile and run:

   ```bash
   tsc && node dist/index.js
   ```

### TypeScript Vite

Set up a TypeScript project with Vite:

1. Create a Vite project:

   ```bash
   npm create vite@latest my-app -- --template vanilla-ts
   ```
2. Navigate and install:

   ```bash
   cd my-app
   npm install
   ```
3. Start the development server:

   ```bash
   npm run dev
   ```