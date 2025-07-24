# JavaScript (JS)

## 📌 What is JavaScript?

* JavaScript is a **client-side scripting language** used to create dynamic and interactive web content.
* Runs in the browser (also used on server-side with Node.js).
* HTML = Structure | CSS = Style | JavaScript = Behavior

---

## 🔤 Basic Syntax

```javascript
// Single-line comment
/*
Multi-line comment
*/

// Variables
let name = "Anirudha";
const age = 25;

// Output
console.log(name);  // Print to console
alert("Hello!");    // Pop-up alert
document.write("Hello HTML!");
```

---

## 🧮 Data Types

* **Primitive Types**:

  * String, Number, Boolean, Null, Undefined, Symbol, BigInt
* **Reference Types**:

  * Object, Array, Function

---

## 🧠 Variables

```javascript
let a = 10;      // Can be reassigned
const pi = 3.14; // Cannot be changed
var oldWay = 5;  // Function-scoped (avoid)
```

---

## 🧰 Operators

* **Arithmetic**: `+`, `-`, `*`, `/`, `%`, `**`
* **Comparison**: `==`, `===`, `!=`, `!==`, `>`, `<`, `>=`, `<=`
* **Logical**: `&&`, `||`, `!`
* **Assignment**: `=`, `+=`, `-=`, etc.

---

## 🔁 Control Flow

### ✅ if-else

```javascript
if (a > b) {
  console.log("A is greater");
} else {
  console.log("B is greater");
}
```

### 🔁 Loops

```javascript
for (let i = 0; i < 5; i++) {
  console.log(i);
}

let i = 0;
while (i < 5) {
  console.log(i);
  i++;
}
```

---

## 🎒 Functions

```javascript
function greet(name) {
  return "Hello " + name;
}
console.log(greet("Anirudha"));

// Arrow Function
const add = (a, b) => a + b;
```

---

## 🧩 Arrays

```javascript
let fruits = ["Apple", "Banana", "Orange"];

console.log(fruits[0]);
fruits.push("Mango");  // Add
fruits.pop();          // Remove
fruits.length;         // Size

fruits.forEach(fruit => console.log(fruit));
```

---

## 📦 Objects

```javascript
let user = {
  name: "Anirudha",
  age: 25,
  greet: function () {
    return "Hello " + this.name;
  }
};

console.log(user.name);
console.log(user.greet());
```

---

## 🌐 DOM (Document Object Model)

### 🔍 Select Elements

```javascript
document.getElementById("demo")
document.querySelector(".btn")
```

### ✍️ Manipulate Elements

```javascript
let title = document.getElementById("title");
title.innerHTML = "Welcome!";
title.style.color = "blue";
```

### 📌 Add Event

```javascript
document.getElementById("btn").addEventListener("click", () => {
  alert("Button clicked!");
});
```

---

## 📂 Events

| Event         | Description        |
| ------------- | ------------------ |
| `onclick`     | Mouse click        |
| `onchange`    | Input value change |
| `onmouseover` | Mouse over         |
| `onkeydown`   | Key pressed        |
| `onload`      | Page load          |

---

## 🕰️ Timing Functions

```javascript
setTimeout(() => {
  alert("Hi after 2 seconds");
}, 2000);

let interval = setInterval(() => {
  console.log("Repeating...");
}, 1000);

// Stop it
clearInterval(interval);
```

---

## 🧪 Form Validation Example

```javascript
function validate() {
  let name = document.getElementById("name").value;
  if (name === "") {
    alert("Name is required");
    return false;
  }
  return true;
}
```

---

## 🌐 JavaScript in HTML

```html
<!-- Internal -->
<script>
  alert("Hello JS!");
</script>

<!-- External -->
<script src="script.js"></script>
```

---

## 🌟 Advanced Topics (For Later Learning)

* ES6+ Features (`let`, `const`, arrow functions, destructuring, spread/rest)
* Asynchronous JS: `setTimeout`, `setInterval`, `fetch`, Promises, `async/await`
* JSON Handling
* LocalStorage / SessionStorage
* Error Handling (`try`, `catch`)
* Modules and Import/Export
* Class-based OOP in JS
* API Integration (`fetch`, `axios`)

---

## 📚 JavaScript Best Practices

* Use `const` or `let` instead of `var`
* Avoid global variables
* Keep functions small and reusable
* Separate logic into modules/files
* Use meaningful names
* Use event delegation
* Comment complex code

---

## 🧰 JavaScript Frameworks and Libraries

| Type      | Examples                         |
| --------- | -------------------------------- |
| Libraries | **jQuery**, **Lodash**           |
| Frontend  | **React**, **Vue**, **Angular**  |
| Backend   | **Node.js**, **Express.js**      |
| Testing   | **Jest**, **Mocha**, **Cypress** |

---
