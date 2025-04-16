// Basic Types
let id: number = 5;  // number type
let company: string = 'Tech Company';  // string type
let isPublished: boolean = true;  // boolean type
let x: any;  // any type can hold any value (not recommended for type safety)
let arr: number[] = [1, 2, 3, 4, 5];  // array of numbers
let tuple: [number, string, boolean] = [1, 'Hello', true];  // tuple with fixed types and order

// if statement: executes block if condition is true
let age: number = 20;
if (age >= 18) {
    console.log("you are eligible for voting");
}

// if-else statement: executes either if-block or else-block
let marks: number = 45;
if (marks >= 50) {
    console.log("passed");
} else {
    console.log("Failed");
}

// if-else-if ladder: checks multiple conditions in sequence
let score: number = 85;
if (score >= 90) {
    console.log("Grade A");
} else if (score >= 80) {
    console.log("Grade B");
} else if (score >= 60) {
    console.log("Grade C");
}
if (score >= 50) {
    console.log("Grade D");
}

// switch-case: multi-way branch statement
let day: number = 3;
switch (day) {
    case 1: console.log("Mon"); break;
    case 2: console.log("Tue"); break;
    case 3: console.log("Wen"); break;
    case 4: console.log("Thu"); break;
    case 5: console.log("Fri"); break;
    case 6: console.log("Sat"); break;
    case 7: console.log("Sun"); break;
    default: console.log("invalid number");
}

// for loop: repeats a block of code a fixed number of times
for (let i: number = 1; i <= 5; i++) {
    console.log("i =", i);
}

// while loop: checks condition first, then executes block
let count: number = 1;
while (count <= 3) {
    console.log("count is ", count);
    count++;
}

// do-while loop: executes block once before checking condition
count = 1;
do {
    console.log("Iteration : ", count);
    count++;
} while (count <= 5);

// for...of loop: iterates over values of iterable objects like arrays
let fruits: string[] = ["Apple", "Banana", "Mango"];
for (let f of fruits) {
    console.log("fruit : ", f);
}

// for...in loop: iterates over keys of an object
let person = { name: "Anirudha", age: 40, address: "Pune" };
for (let key in person) {
    console.log(`${key} : ${person[key as keyof typeof person]}`);
}

// break: exits loop when condition is met
for (let x: number = 1; x <= 5; x++) {
    if (x === 3) {
        break;
    }
    console.log(x);
}

// continue: skips current iteration when condition is met
for (let x: number = 1; x <= 5; x++) {
    if (x === 3) {
        continue;
    }
    console.log(x);
}

// function with parameters and return type
function add(a: number, b: number): number {
    return a + b;
}
let result: number = add(10, 5);
console.log("Sum ", result);

// void function: performs action but does not return a value
function greet(msg: string): void {
    console.log("Message : ", msg);
}
greet("Hello");

//OOPs concepts in TypeScript

/*
## ✅ 1. Class  
A blueprint for creating objects with properties and methods.
*/

class Person {
    name: string;
    age: number;

    constructor(name: string, age: number){
        this.name = name;
        this.age = age;
    }

    greet(): void {
        console.log(`Hello, my name is ${this.name} and I am ${this.age} years old.`);
    }
}

const person1 = new Person("Anirudha", 25);
person1.greet();



/*
## ✅ 2. Encapsulation  
Wrapping data and methods into a single unit (class). Use `private`, `public`, `protected` keywords to control access.
*/

class BankAccount {
    private balance: number = 0;

    deposit(amount: number): void {
        if(amount > 0) {
            this.balance += amount;
        }
    }

    getBalance(): number {
        return this.balance;
    }
}

const account = new BankAccount();
account.deposit(1000);
// account.balance = 9999; ❌ Error: balance is private
console.log("Balance: ", account.getBalance());



/*
## ✅ 3. Inheritance  
Allows a class to inherit properties and methods from another class.
Type | Description | Supported in TypeScript
Single Inheritance | One class inherits from one parent | ✅ Yes
Multilevel Inheritance | Inheritance in chain (GrandParent → Parent → Child) | ✅ Yes
Hierarchical Inheritance | Multiple classes from one parent | ✅ Yes
Multiple Inheritance | One class inherits from multiple classes | ❌ No (use interfaces)
*/

class Animal {
    move(): void {
        console.log("Animal is moving");
    }
}

class Dog extends Animal {
    bark(): void {
        console.log("Dog is barking");
    }
}

const dog = new Dog();
dog.move();  // Inherited method
dog.bark();  // Own method



/*
## ✅ 4. Polymorphism  
A method can behave differently based on the object that calls it.
*/

class Shape {
    area(): void {
        console.log("Calculating area...");
    }
}

class Circle extends Shape {
    area(): void {
        console.log("Area of Circle = πr²");
    }
}

class Rectangle extends Shape {
    area(): void {
        console.log("Area of Rectangle = l × b");
    }
}

let shapes: Shape[] = [new Circle(), new Rectangle()];
for (let s of shapes) {
    s.area();  // Calls the overridden version
}



/*
## ✅ 5. Abstraction  
Hiding complex implementation details and showing only essential features.
*/

abstract class Vehicle {
    abstract startEngine(): void;
    abstract stopEngine(): void;
}

class Car extends Vehicle {
    startEngine(): void {
        console.log("Car engine started.");
    }

    stopEngine(): void {
        console.log("Car engine stopped.");
    }
}

const myCar = new Car();
myCar.startEngine();
myCar.stopEngine();


/*
## ✅ 6. Interface
An interface defines the structure (contract) of an object. It’s like a blueprint for classes or objects — defining what should be there, not how it's implemented.
### ✅ Interface with Object
*/

interface Student {
    name: string;
    age: number;
    course: string;
    enroll(): void;
}

const student1: Student = {
    name: "Anirudha",
    age: 22,
    course: "Computer Science",
    enroll() {
        console.log(`${this.name} enrolled in ${this.course}`);
    }
};

student1.enroll();


/*
### ✅ Interface with Class
*/

interface Printable {
    print(): void;
}

class Invoice implements Printable {
    constructor(private customer: string, private amount: number) {}

    print(): void {
        console.log(`Invoice for ${this.customer}: ₹${this.amount}`);
    }
}

const invoice = new Invoice("Anirudha", 5000);
invoice.print();



/*
### ✅ Interface as Function Type
*/

interface AddFunc {
    (a: number, b: number): number;
}

const addFun: AddFunc = (x, y) => x + y;

console.log("Addition:", addFun(5, 10));


/*
### ✅ Interface with Optional & Readonly Properties
*/

interface User {
    readonly id: number; // cannot be changed after assignment
    name: string;
    email?: string; // optional property
}

let user1: User = { id: 1, name: "Anirudha" };
console.log(user1);

// user1.id = 2; ❌ Error: Cannot assign to 'id' because it is a read-only property


/*
## ✅ Summary of OOP + Interface

| Concept        | Meaning                                  | TypeScript Keyword |
|-||--|
| Class          | Blueprint for objects                    | `class`            |
| Object         | Instance of class                        | `new`              |
| Encapsulation  | Data hiding via access modifiers         | `private`, `public`, `protected` |
| Inheritance    | Inherit properties from another class    | `extends`          |
| Polymorphism   | Many forms via method overriding         | `override` (optional) |
| Abstraction    | Hide complexity using abstract classes   | `abstract`         |
| Interface      | Contract that defines structure          | `interface`        |

*/

