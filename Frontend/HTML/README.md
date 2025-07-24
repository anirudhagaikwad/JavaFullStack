## Introduction to HTML5

HTML5 is the latest version of HyperText Markup Language used for structuring and presenting content on the World Wide Web. It introduces new semantic elements, attributes, and behaviors, providing more powerful and flexible features for web developers.

---

## 1. `<!DOCTYPE html>`

* Declares the document type and HTML version.
* Must be the very first line in an HTML5 document.

```html
<!DOCTYPE html>
```

---

## 2. `<html>` Element

* The root element that wraps the entire HTML content.
* **Attributes**:

  * `lang`: Specifies the language of the document. It defines the language used in the content of the web page for accessibility, screen readers, and search engines.

### Common `lang` Codes:

* `en` – English
* `hi` – Hindi
* `mr` – Marathi
* `fr` – French
* `de` – German
* `es` – Spanish
* `zh` – Chinese (Simplified)
* `ja` – Japanese
* `ar` – Arabic

### Regional Variants:

* `en-US` – English (United States)
* `en-GB` – English (United Kingdom)
* `fr-CA` – French (Canada)
* `pt-BR` – Portuguese (Brazil)

> For the full list of valid `lang` codes, refer to the IANA Language Subtag Registry: [https://www.iana.org/assignments/language-subtag-registry/language-subtag-registry](https://www.iana.org/assignments/language-subtag-registry/language-subtag-registry)

```html
<html lang="en">
  ...
</html>
```

---

## 3. `<head>` Element

Contains metadata about the document such as title, charset, links to stylesheets, and scripts.

### Common `<head>` Tags:

* `<meta>`: Metadata about the document

  * `charset="UTF-8"`: Specifies character encoding
  * `name="viewport"`: Responsive design
  * `name="description"`, `name="keywords"`, `name="author"`
* `<title>`: Title displayed in browser tab
* `<link>`: Links external resources like CSS
* `<style>`: Internal CSS
* `<script>`: JavaScript (often placed at end of body)

```html
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="Learning HTML5">
  <meta name="author" content="Anirudha Anil Gaikwad">
  <title>My First Website</title>
  <link rel="stylesheet" href="styles.css">
  <style>
    body { font-family: Arial; }
  </style>
</head>
```

---

## 4. `<body>` Element

* Contains the content of the HTML document that is visible to users.

```html
<body>
  ...
</body>
```

---

## 5. Semantic Elements

Help define the structure and meaning of content.

### `<header>`

* Represents introductory content or navigation links.

### `<nav>`

* Defines navigation links.

```html
<nav>
  <ul>
    <li><a href="#home">Home</a></li>
    <li><a href="#about">About</a></li>
  </ul>
</nav>
```

### `<main>`

* Represents the main content of the document.

### `<section>`

* Represents a standalone section.

### `<article>`

* Represents self-contained content.

### `<aside>`

* Represents content aside from the main content (sidebars).

### `<footer>`

* Represents the footer section of a document or section.

```html
<footer>
  <p>&copy; 2025 My Website</p>
</footer>
```

---

## 6. `<div>`

* Generic container with no semantic meaning.
* Used for styling or layout purposes.
* **Attributes**:

  * `class`, `id`, `style`

```html
<div class="container">
  <p>This is a content block.</p>
</div>
```

---

## 7. Forms in HTML5

Used to collect user input.

### `<form>`

**Attributes**:

* `action`: URL to send form data
* `method`: GET or POST
* `target`, `autocomplete`, `novalidate`

### `<label>`

* Describes input controls.
* Attribute: `for` binds to input `id`

```html
<label for="name">Name:</label>
<input type="text" id="name" name="name">
```

### `<input>`

* **Types**: `text`, `email`, `password`, `number`, `radio`, `checkbox`, `submit`, `reset`, `file`, `url`, `date`, `color`, `range`, `search`
* **Common Attributes**:

  * `type`, `name`, `id`, `value`, `required`, `placeholder`, `min`, `max`, `step`, `pattern`, `checked`, `readonly`, `disabled`

```html
<input type="email" name="email" required>
```

### Other Input Elements:

* `<textarea>`: Multi-line input

  * Attributes: `rows`, `cols`, `maxlength`, `placeholder`
* `<select>`: Dropdown list

  * Attributes: `multiple`, `size`
* `<option>`: Options in select

  * Attribute: `selected`
* `<button>`: Clickable button

  * Attribute: `type` (button, submit, reset)

### Example:

```html
<form action="/submit" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required><br>

  <label for="message">Message:</label><br>
  <textarea id="message" name="message" rows="4" cols="50"></textarea><br>

  <input type="submit" value="Send">
</form>
```

---

## 8. Tables

Used to display tabular data.

### Tags:

* `<table>`: Defines table
* `<tr>`: Table row
* `<td>`: Table data
* `<th>`: Table header
* `<thead>`, `<tbody>`, `<tfoot>`: Table sections

### Common Attributes:

* `border`, `cellpadding`, `cellspacing`, `width`, `height`, `align`

### Example:

```html
<table border="1">
  <thead>
    <tr>
      <th>Name</th>
      <th>Email</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Anirudha</td>
      <td>example@email.com</td>
    </tr>
  </tbody>
</table>
```

---

## 9. Multimedia Tags

### `<img>`

* Embeds images into the page.
* **Attributes**: `src`, `alt`, `width`, `height`, `loading`, `title`

```html
<img src="image.jpg" alt="Description" width="300" height="200">
```

### `<audio>`

* Embeds audio files.
* **Attributes**: `src`, `controls`, `autoplay`, `loop`, `muted`, `preload`

```html
<audio controls>
  <source src="sound.mp3" type="audio/mpeg">
  Your browser does not support the audio element.
</audio>
```

### `<video>`

* Embeds video files.
* **Attributes**: `src`, `controls`, `autoplay`, `loop`, `muted`, `poster`, `preload`, `width`, `height`

```html
<video width="320" height="240" controls>
  <source src="movie.mp4" type="video/mp4">
  Your browser does not support the video tag.
</video>
```

---

## 10. Other Important Tags

### `<ul>` (Unordered List)

* Displays bullet lists.
* **Attributes**: `type` (disc, circle, square) – *Note: deprecated in HTML5, use CSS instead*

```html
<ul>
  <li>Item 1</li>
  <li>Item 2</li>
</ul>
```

### `<ol>` (Ordered List)

* Numbered list.
* **Attributes**: `type` (1, A, a, I, i), `start`, `reversed`

```html
<ol type="A" start="3">
  <li>Item A</li>
  <li>Item B</li>
</ol>
```

### `<br>`: Line break

### `<hr>`: Thematic break (horizontal line)

### `<a>`: Anchor (hyperlink)

* **Attributes**: `href`, `target`, `title`, `rel`

### `<span>`: Inline container

### `<strong>`, `<em>`: Bold and italic for emphasis

---

## Conclusion

HTML5 is a powerful and essential tool for building modern, structured, and responsive websites. It supports semantic markup, multimedia, forms, and clean integration with CSS and JavaScript.

Use these tags wisely to ensure accessibility, maintainability, and search engine friendliness.

---
