var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// Basic Types
var id = 5; // number type
var company = 'Tech Company'; // string type
var isPublished = true; // boolean type
var x; // any type can hold any value (not recommended for type safety)
var arr = [1, 2, 3, 4, 5]; // array of numbers
var tuple = [1, 'Hello', true]; // tuple with fixed types and order
// if statement: executes block if condition is true
var age = 20;
if (age >= 18) {
    console.log("you are eligible for voting");
}
// if-else statement: executes either if-block or else-block
var marks = 45;
if (marks >= 50) {
    console.log("passed");
}
else {
    console.log("Failed");
}
// if-else-if ladder: checks multiple conditions in sequence
var score = 85;
if (score >= 90) {
    console.log("Grade A");
}
else if (score >= 80) {
    console.log("Grade B");
}
else if (score >= 60) {
    console.log("Grade C");
}
if (score >= 50) {
    console.log("Grade D");
}
// switch-case: multi-way branch statement
var day = 3;
switch (day) {
    case 1:
        console.log("Mon");
        break;
    case 2:
        console.log("Tue");
        break;
    case 3:
        console.log("Wen");
        break;
    case 4:
        console.log("Thu");
        break;
    case 5:
        console.log("Fri");
        break;
    case 6:
        console.log("Sat");
        break;
    case 7:
        console.log("Sun");
        break;
    default: console.log("invalid number");
}
// for loop: repeats a block of code a fixed number of times
for (var i = 1; i <= 5; i++) {
    console.log("i =", i);
}
// while loop: checks condition first, then executes block
var count = 1;
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
var fruits = ["Apple", "Banana", "Mango"];
for (var _i = 0, fruits_1 = fruits; _i < fruits_1.length; _i++) {
    var f = fruits_1[_i];
    console.log("fruit : ", f);
}
// for...in loop: iterates over keys of an object
var person = { name: "Anirudha", age: 40, address: "Pune" };
for (var key in person) {
    console.log("".concat(key, " : ").concat(person[key]));
}
// break: exits loop when condition is met
for (var x_1 = 1; x_1 <= 5; x_1++) {
    if (x_1 === 3) {
        break;
    }
    console.log(x_1);
}
// continue: skips current iteration when condition is met
for (var x_2 = 1; x_2 <= 5; x_2++) {
    if (x_2 === 3) {
        continue;
    }
    console.log(x_2);
}
// function with parameters and return type
function add(a, b) {
    return a + b;
}
var result = add(10, 5);
console.log("Sum ", result);
// void function: performs action but does not return a value
function greet(msg) {
    console.log("Message : ", msg);
}
greet("Hello");
//OOPs concepts in TypeScript
/*
## ✅ 1. Class
A blueprint for creating objects with properties and methods.
*/
var Person = /** @class */ (function () {
    function Person(name, age) {
        this.name = name;
        this.age = age;
    }
    Person.prototype.greet = function () {
        console.log("Hello, my name is ".concat(this.name, " and I am ").concat(this.age, " years old."));
    };
    return Person;
}());
var person1 = new Person("Anirudha", 25);
person1.greet();
/*
## ✅ 2. Encapsulation
Wrapping data and methods into a single unit (class). Use `private`, `public`, `protected` keywords to control access.
*/
var BankAccount = /** @class */ (function () {
    function BankAccount() {
        this.balance = 0;
    }
    BankAccount.prototype.deposit = function (amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    };
    BankAccount.prototype.getBalance = function () {
        return this.balance;
    };
    return BankAccount;
}());
var account = new BankAccount();
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
var Animal = /** @class */ (function () {
    function Animal() {
    }
    Animal.prototype.move = function () {
        console.log("Animal is moving");
    };
    return Animal;
}());
var Dog = /** @class */ (function (_super) {
    __extends(Dog, _super);
    function Dog() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Dog.prototype.bark = function () {
        console.log("Dog is barking");
    };
    return Dog;
}(Animal));
var dog = new Dog();
dog.move(); // Inherited method
dog.bark(); // Own method
/*
## ✅ 4. Polymorphism
A method can behave differently based on the object that calls it.
*/
var Shape = /** @class */ (function () {
    function Shape() {
    }
    Shape.prototype.area = function () {
        console.log("Calculating area...");
    };
    return Shape;
}());
var Circle = /** @class */ (function (_super) {
    __extends(Circle, _super);
    function Circle() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Circle.prototype.area = function () {
        console.log("Area of Circle = πr²");
    };
    return Circle;
}(Shape));
var Rectangle = /** @class */ (function (_super) {
    __extends(Rectangle, _super);
    function Rectangle() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Rectangle.prototype.area = function () {
        console.log("Area of Rectangle = l × b");
    };
    return Rectangle;
}(Shape));
var shapes = [new Circle(), new Rectangle()];
for (var _a = 0, shapes_1 = shapes; _a < shapes_1.length; _a++) {
    var s = shapes_1[_a];
    s.area(); // Calls the overridden version
}
/*
## ✅ 5. Abstraction
Hiding complex implementation details and showing only essential features.
*/
var Vehicle = /** @class */ (function () {
    function Vehicle() {
    }
    return Vehicle;
}());
var Car = /** @class */ (function (_super) {
    __extends(Car, _super);
    function Car() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Car.prototype.startEngine = function () {
        console.log("Car engine started.");
    };
    Car.prototype.stopEngine = function () {
        console.log("Car engine stopped.");
    };
    return Car;
}(Vehicle));
var myCar = new Car();
myCar.startEngine();
myCar.stopEngine();
var student1 = {
    name: "Anirudha",
    age: 22,
    course: "Computer Science",
    enroll: function () {
        console.log("".concat(this.name, " enrolled in ").concat(this.course));
    }
};
student1.enroll();
var Invoice = /** @class */ (function () {
    function Invoice(customer, amount) {
        this.customer = customer;
        this.amount = amount;
    }
    Invoice.prototype.print = function () {
        console.log("Invoice for ".concat(this.customer, ": \u20B9").concat(this.amount));
    };
    return Invoice;
}());
var invoice = new Invoice("Anirudha", 5000);
invoice.print();
var addFun = function (x, y) { return x + y; };
console.log("Addition:", addFun(5, 10));
var user1 = { id: 1, name: "Anirudha" };
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
