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
# 🎨 CSS Gradients

## 🔹 What is a Gradient?

A **gradient** is a smooth transition between two or more specified colors. Instead of using an image, you can use gradients to create background effects, making your site lighter and more scalable.

Gradients are declared in CSS using the `background-image` property with a gradient function such as:

* `linear-gradient()`
* `radial-gradient()`
* `conic-gradient()` (CSS Level 4)

---

## 🔹 1. `linear-gradient()`

Creates a gradient in a straight line (top to bottom by default).

### Syntax:

```css
background-image: linear-gradient(direction, color1, color2, ...);
```

### Directions:

* `to right` – left to right
* `to left` – right to left
* `to top` – bottom to top
* `to bottom` – top to bottom (default)
* You can also use angles like `45deg`, `135deg`, etc.

### Example:

```css
background-image: linear-gradient(to right, red, yellow);
```

### Multiple Color Stops:

```css
background-image: linear-gradient(to right, red, orange, yellow, green, blue);
```

### With Transparency:

```css
background-image: linear-gradient(to bottom, rgba(255,0,0,0.5), rgba(0,0,255,0.5));
```

---

## 🔹 2. `radial-gradient()`

Creates a gradient radiating from a central point (like a circle or ellipse).

### Syntax:

```css
background-image: radial-gradient(shape size at position, color1, color2, ...);
```

### Common Shapes:

* `circle`
* `ellipse` (default)

### Example:

```css
background-image: radial-gradient(circle, red, yellow, green);
```

### Positioning:

```css
background-image: radial-gradient(circle at center, red, yellow);
background-image: radial-gradient(circle at top left, red, yellow);
```

---

## 🔹 3. `conic-gradient()` (CSS4)

Creates a gradient that spins around a center point like a pie chart.

> 📌 Not supported in older browsers (ensure compatibility).

### Syntax:

```css
background-image: conic-gradient(from angle at position, color1, color2, ...);
```

### Example:

```css
background-image: conic-gradient(red, yellow, green, blue);
```

### With Angles:

```css
background-image: conic-gradient(from 90deg, red, yellow, green);
```

---

## 🔹 4. Repeating Gradients

Repeating gradients repeat themselves to fill the entire element.

### Types:

* `repeating-linear-gradient()`
* `repeating-radial-gradient()`
* `repeating-conic-gradient()` (CSS4)

### Example:

```css
background-image: repeating-linear-gradient(to right, red, red 10px, white 10px, white 20px);
```

---

## 🔹 5. Fallback Background Color

Browsers that do not support gradients will show a solid color.

```css
background-color: #ff0000; /* fallback */
background-image: linear-gradient(to right, red, yellow);
```

---

## 🔹 Use Cases of Gradients

* Button backgrounds
* Page backgrounds
* Hover effects
* Cards and UI elements
* Charts with `conic-gradient`

---

## 🔹 Best Practices

* Use color contrast wisely for readability.
* Prefer `background-image` for gradients.
* Combine with `background-size`, `background-position`, and `background-repeat` for advanced designs.
* Keep performance in mind—gradients are lighter than images!

---


# 🎞️ CSS Gradient Animation Effects

Gradients can be made dynamic using **CSS animations** to create visually appealing backgrounds and transitions. This adds a modern and smooth effect to your webpage.

---

## 🔹 1. Animate Gradient Position (Shifting Colors)

### Example: Moving Gradient Background

```html
<style>
body {
  height: 100vh;
  background: linear-gradient(270deg, #ff6ec4, #7873f5, #3acbf0);
  background-size: 600% 600%;
  animation: animateBg 10s ease infinite;
}

@keyframes animateBg {
  0%   { background-position: 0% 50%; }
  50%  { background-position: 100% 50%; }
  100% { background-position: 0% 50%; }
}
</style>
```

### 🔍 Explanation:

* `background-size: 600% 600%`: Makes the gradient larger than the element so it can move.
* `background-position`: Changes where the gradient is shown.
* `animation`: Loops the `@keyframes` to animate the gradient.

---

## 🔹 2. Animated Gradient Border

```html
<style>
.animated-border {
  border: 5px solid transparent;
  background: linear-gradient(90deg, red, orange, yellow, green, blue, indigo, violet);
  background-size: 400% 400%;
  animation: borderAnimate 5s linear infinite;
  border-radius: 10px;
  padding: 20px;
  color: white;
  font-weight: bold;
}

@keyframes borderAnimate {
  0%   { background-position: 0% 50%; }
  100% { background-position: 100% 50%; }
}
</style>

<div class="animated-border">Gradient Border</div>
```

---

## 🔹 3. Text with Animated Gradient (Using `background-clip`)

```html
<style>
.gradient-text {
  font-size: 50px;
  font-weight: bold;
  background: linear-gradient(-45deg, #ff6ec4, #7873f5, #3acbf0);
  background-size: 400% 400%;
  animation: textGradient 6s ease infinite;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

@keyframes textGradient {
  0%   { background-position: 0% 50%; }
  50%  { background-position: 100% 50%; }
  100% { background-position: 0% 50%; }
}
</style>

<div class="gradient-text">Animated Text</div>
```

---

## 🔹 4. Animated Conic Gradient Spinner

```html
<style>
.loader {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  background: conic-gradient(red, orange, yellow, green, blue, indigo, violet, red);
  animation: spin 2s linear infinite;
}

@keyframes spin {
  0%   { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>

<div class="loader"></div>
```

---

## 🧠 Tips for Gradient Animation

* Always combine gradients with `background-size` and `background-position` for smooth animations.
* Use `ease-in-out` or `linear` easing functions depending on effect.
* Conic gradients require modern browser support.
* Optimize performance by not overusing high-resolution animated gradients on large pages.

---

