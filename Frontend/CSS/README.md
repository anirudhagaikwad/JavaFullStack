# CSS

## 📌 What is CSS?

**CSS (Cascading Style Sheets)** is used to style HTML elements. It defines how elements should look—colors, sizes, layouts, fonts, spacing, etc.

---

## 🔗 Ways to Use CSS

1. **Inline CSS**
   Inside an HTML element (not recommended for large projects)

   ```html
   <p style="color: red;">Hello World</p>
   ```

2. **Internal CSS**
   Inside `<style>` tag in the `<head>` section.

   ```html
   <style>
     p { color: red; }
   </style>
   ```

3. **External CSS**
   Linked via a `.css` file (Recommended)

   ```html
   <link rel="stylesheet" href="style.css">
   ```

---

## 🧱 CSS Syntax

```css
selector {
  property: value;
}
```

Example:

```css
h1 {
  color: blue;
  font-size: 32px;
}
```

---

## 🎯 CSS Selectors

| Selector        | Description                       |
| --------------- | --------------------------------- |
| `*`             | Universal selector (all elements) |
| `p`             | Element selector (all `<p>` tags) |
| `.class`        | Class selector                    |
| `#id`           | ID selector                       |
| `div p`         | Descendant selector               |
| `div > p`       | Direct child                      |
| `a:hover`       | Pseudo-class                      |
| `[type="text"]` | Attribute selector                |

---

## 🧩 Common CSS Properties

### Text & Font

```css
color: red;
font-size: 16px;
font-weight: bold;
font-family: Arial, sans-serif;
text-align: center;
text-decoration: underline;
letter-spacing: 1px;
line-height: 1.5;
```

### Backgrounds

```css
background-color: lightblue;
background-image: url("image.jpg");
background-repeat: no-repeat;
background-size: cover;
```

### Box Model

```css
margin: 20px;
padding: 10px;
border: 1px solid black;
width: 300px;
height: 200px;
```

### Display & Position

```css
display: block | inline | inline-block | flex | grid | none;
position: static | relative | absolute | fixed | sticky;
top, bottom, left, right: 10px;
z-index: 10;
```

---

## 📦 The CSS Box Model

Every HTML element is a box:

```
| margin          |
|  border         |
|   padding       |
|    content      |
```

* `content`: Actual content (text/image)
* `padding`: Space around content
* `border`: Line around the padding
* `margin`: Space outside the border

---

## 🎨 Colors in CSS

* Named: `red`, `blue`, `green`
* HEX: `#ff0000`, `#00ff00`
* RGB: `rgb(255,0,0)`
* RGBA: `rgba(0,0,255,0.5)`
* HSL: `hsl(120, 100%, 50%)`

---

## 📐 Units in CSS

| Unit    | Meaning                      |
| ------- | ---------------------------- |
| `px`    | Pixels (fixed)               |
| `em`    | Relative to parent font size |
| `rem`   | Relative to root font size   |
| `%`     | Percentage                   |
| `vh/vw` | Viewport height/width        |

---

## 🧭 Layout Techniques

### Flexbox

```css
display: flex;
flex-direction: row | column;
justify-content: center | space-between;
align-items: center;
gap: 10px;
```

### Grid

```css
display: grid;
grid-template-columns: 1fr 2fr;
grid-gap: 10px;
```

---

## 🧪 Pseudo-classes

```css
a:hover { color: red; }
input:focus { border: 1px solid blue; }
li:first-child { font-weight: bold; }
```

---

## 🧮 Forms Styling

```css
input, select, textarea {
  padding: 10px;
  border: 1px solid gray;
  border-radius: 4px;
  font-size: 14px;
}
input:focus {
  outline: none;
  border-color: blue;
}
button {
  background-color: green;
  color: white;
  padding: 10px 20px;
}
```

---

## 📊 Table Styling

```css
table {
  border-collapse: collapse;
  width: 100%;
}
th, td {
  padding: 10px;
  border: 1px solid #ddd;
}
tr:nth-child(even) {
  background-color: #f2f2f2;
}
```

---

## 🧱 Media Queries (Responsive Design)

```css
@media screen and (max-width: 768px) {
  body {
    background-color: lightgray;
  }
}
```

---

## 🧠 Best Practices

* Use external CSS files for maintainability
* Group related styles with comments
* Use semantic class names (`.btn-primary`, `.nav-bar`)
* Avoid inline styles in production
* Mobile-first design with media queries
* Organize CSS using logical sections: layout, typography, components, etc.

---

## 📁 Example Folder Structure

```
project/
│
├── index.html
├── css/
│   └── style.css
└── images/
    └── logo.png
```

---

## ✅ Quick Example

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>CSS Example</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <h1 class="title">Welcome</h1>
  <p>This is a styled paragraph.</p>
  <button class="btn">Click Me</button>
</body>
</html>
```

```css
/* style.css */
body {
  font-family: sans-serif;
  background-color: #f9f9f9;
  padding: 20px;
}

.title {
  color: blue;
}

.btn {
  background: blue;
  color: white;
  border: none;
  padding: 10px 20px;
}
```

---

# Animations & transitions

## 🎬 CSS Transitions

**Transitions** allow smooth changes between property values over time.

### ✅ Syntax:

```css
selector {
  transition: property duration timing-function delay;
}
```

### ✅ Example:

```css
.box {
  background-color: red;
  transition: background-color 0.5s ease-in-out;
}

.box:hover {
  background-color: blue;
}
```

### 🎯 Common Transition Properties:

* `transition-property`: Which CSS property to animate (e.g., `background`, `all`)
* `transition-duration`: How long the transition takes (`1s`, `500ms`)
* `transition-delay`: Delay before transition starts
* `transition-timing-function`: Speed curve (ease, linear, ease-in, ease-out, ease-in-out)

---

## 🎞️ CSS Animations

**Animations** define multiple steps of styling using keyframes.

### ✅ Syntax:

```css
@keyframes mymove {
  0%   { left: 0px; }
  100% { left: 100px; }
}

.box {
  position: relative;
  animation-name: mymove;
  animation-duration: 2s;
}
```

### ✅ Animation Properties:

* `animation-name`: Name of keyframes
* `animation-duration`: Total time of animation
* `animation-delay`: Delay before animation starts
* `animation-iteration-count`: Number of times animation should repeat (`infinite`)
* `animation-direction`: `normal`, `reverse`, `alternate`
* `animation-fill-mode`: `forwards`, `backwards`, `both`, `none`
* `animation-timing-function`: Controls pacing (like transition)

---

## 🧰 Popular CSS Frameworks

Frameworks help speed up design with pre-built components.

### 🌐 General Purpose Frameworks

| Framework        | Key Features                                         |
| ---------------- | ---------------------------------------------------- |
| **Bootstrap**    | Responsive grid, buttons, forms, navbars, JS plugins |
| **Tailwind CSS** | Utility-first, fully customizable, fast to develop   |
| **Bulma**        | Flexbox-based, semantic classes, mobile-first        |
| **Foundation**   | Accessibility-focused, responsive, flexible          |
| **UIkit**        | Lightweight and modern UI components                 |

---

### 🧩 UI Component Libraries (Theme Ready)

| Framework       | Description                               |
| --------------- | ----------------------------------------- |
| **Materialize** | Based on Google’s Material Design         |
| **Metro 4**     | Windows Metro-style modern UI             |
| **Shoelace**    | Native Web Components, framework-agnostic |

---

### 🎨 Minimalist and Utility Frameworks

| Framework     | Description                           |
| ------------- | ------------------------------------- |
| **Milligram** | Minimalist, clean defaults, Flexbox   |
| **Pico.css**  | Classless, semantic HTML, responsive  |
| **Skeleton**  | Lightweight boilerplate (\~400 lines) |

---

## 🔥 Tips for Using Transitions & Animations

* Use `ease-in-out` for smooth appearance
* Avoid too many animations – keep user experience clean
* Use `will-change: transform` to optimize performance
* Test animations across devices and browsers
* Combine with media queries for responsive effects

---




