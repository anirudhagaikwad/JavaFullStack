# 🌟 Angular 19 Notes

## 📌 1. Introduction to Angular
Angular is a **TypeScript-based open-source web application framework** developed by **Google**, used for building **single-page applications (SPAs)**.  
It provides:
- A component-based framework for building scalable web applications.
- A collection of well-integrated libraries (routing, forms, client-server communication, etc.).
- Developer tools for development, build, testing, and updates.

---

## 🏗️ 2. Angular Architecture
- **Modules**: Group components, directives, pipes, and services.
- **Components**: Core building blocks controlling parts of the UI.
- **Templates**: HTML + Angular syntax (interpolation, directives).
- **Services**: Business logic that can be shared across components.
- **Dependency Injection**: Inject services into components or other services.
- **Routing**: Navigates between components/pages.

---

## ⚙️ 3. Angular CLI
The **Angular CLI** is the fastest and easiest way to develop Angular applications.

### Common Commands:
| Command | Description |
|--------|-------------|
| `ng new <project-name>` | Create a new Angular project |
| `ng serve` | Start development server with hot reload |
| `ng generate <type> <name>` | Generate a component/service/module |
| `ng build` | Compile the application for production |
| `ng test` | Run unit tests |
| `ng e2e` | Run end-to-end tests |

---

## 🧱 4. Components
- Defined using the `@Component` decorator.
- Composed of:
  - **Selector**: Custom HTML tag name.
  - **Template**: HTML layout.
  - **Style**: CSS or SCSS styles.
  - **Class**: TypeScript logic and data handling.
- A component = `.ts` + `.html` + `.css`

---

## 🔁 5. Data Binding (4 Types)
1. **Interpolation** – `{{ expression }}`: Display dynamic data.
2. **Property Binding** – `[property]="expression"`: Set HTML element properties.
3. **Event Binding** – `(event)="handler()"`: Respond to user actions.
4. **Two-way Binding** – `[(ngModel)]="property"`: Sync between UI and component (requires `FormsModule`).

---

## 🎯 6. Directives
- **Structural Directives**: Modify layout.
  - `*ngIf`, `*ngFor`
- **Attribute Directives**: Modify appearance or behavior.
  - `[ngClass]`, `[ngStyle]`
- You can create **custom directives**.

## 🔣 6.1 Pipes
Pipes are used to **transform data in templates**. They are simple functions that accept an input and return a transformed output, used via the pipe `|` symbol.

### 🔧 Built-in Pipes:

| Pipe        | Example Usage                         | Description                            |
|-------------|----------------------------------------|----------------------------------------|
| `date`      | `` {{ today \| date:'short' }} ``      | Formats a date value                   |
| `uppercase` | `` {{ name \| uppercase }} ``          | Converts text to uppercase             |
| `lowercase` | `` {{ name \| lowercase }} ``          | Converts text to lowercase             |
| `currency`  | `` {{ amount \| currency:'INR' }} ``   | Formats a number as currency           |
| `percent`   | `` {{ value \| percent }} ``           | Formats a number as a percentage       |
| `json`      | `` {{ object \| json }} ``             | Converts object to JSON string         |
| `slice`     | `` {{ items \| slice:1:4 }} ``         | Returns selected items from list       |
| `async`     | `` {{ observableData \| async }} ``    | Subscribes and outputs Observable value|

---

### 🛠️ Custom Pipes

You can create custom pipes using the Angular CLI:

```bash
ng generate pipe customPipeName

```
example
```
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'reverse' })
export class ReversePipe implements PipeTransform {
  transform(value: string): string {
    return value.split('').reverse().join('');
  }
}

```
use in html

```
{{ 'Angular' | reverse }} <!-- Output: ralugnA -->

```
Pipes are ideal for transforming data in the view without altering the component logic.
---

## 🧭 7. Routing
- Manages navigation between views.
- Defined in `app-routing.module.ts` using `RouterModule`.
- Route config: `{ path: 'home', component: HomeComponent }`
- Supports:
  - **Route Parameters**
  - **Guards** (e.g., `CanActivate`)
  - **Lazy Loading**

---

## 🗃️ 8. Modules
- Organize app into cohesive blocks.
- Defined using `@NgModule`.
- **AppModule** is the root module.
- Use **Feature Modules** for large apps.

---

## 📦 9. Services & Dependency Injection
- Create services using `ng generate service <name>`.
- Share logic and data between components.
- Inject using constructor via Angular’s **DI system**.

---

## 🌐 10. HTTP Client
- Import `HttpClientModule` to use Angular's `HttpClient`.
- Supports `GET`, `POST`, `PUT`, `DELETE`.
- Uses **RxJS Observables** for async handling.

---

## ✅ 11. Forms
- **Template-driven Forms**: Simple, use `[(ngModel)]`.
- **Reactive Forms**: Complex, scalable forms using `FormGroup`, `FormControl`, `FormBuilder`.

---

## 🧪 12. Testing
- Angular supports **unit** and **end-to-end** testing.
- Tools:
  - **Jasmine**: Test framework.
  - **Karma**: Test runner.

---

## 🧰 13. Build & Deployment
- Build app with:
  ```bash
  ng build --prod
  ```
- Output is placed in the `dist/` folder.
- Can be deployed to:
  - Firebase
  - Netlify
  - GitHub Pages

---

## 🔄 14. Lifecycle Hooks
Angular provides lifecycle methods in components:
- `ngOnInit()` – On component init.
- `ngOnChanges()` – On input data change.
- `ngOnDestroy()` – Before component removal.

---

## 🆕 15. What’s New in Angular 19
- **Signals**: Fine-grained reactive state tracking.
- **Improved SSR Hydration**: Enhanced server-side rendering.
- **Vite Support**: Super-fast dev/build setup.
- **Better Build Performance**
- **Angular CLI Improvements**
- **Updated RxJS Compatibility**

---

## ⚙️ Prerequisites
- **Node.js**: v22.14.0
- **Editor**: Visual Studio Code (recommended)
- **Terminal**: For Angular CLI commands
- **Dev Tool**: Angular Language Service  
  [Download VS Code](https://code.visualstudio.com/)

---

## 🛠️ Setup Guide

### 1. Install Angular CLI
```bash
npm install -g @angular/cli
```

### 2. Check Angular Version
```bash
ng version
```

### 3. Install Angular Material
```bash
ng add @angular/material
```

---

## 📁 Angular Project Directory Structure

```bash
APP/
├── ngApp/
│   ├── .angular/            # Webpack & Babel configs
│   ├── .vscode/
│   ├── node_modules/        # Dependencies
│   ├── src/                 # Application source code
│   ├── angular.json         # Angular config
│   ├── package.json         # Project metadata & dependencies
│   ├── tsconfig.json        # TypeScript config
│   └── README.md
```

### 🔹 Inside `src/app`:

```bash
src/app/
├── app.component.css        # Styles
├── app.component.html       # Template
├── app.component.ts         # Component logic
├── app.component.spec.ts    # Unit tests
└── app.config.ts            # Configuration
```

---

## 🔄 AngularJS vs Angular

| Feature | AngularJS | Angular |
|--------|------------|---------|
| Version | 1.x | 2 and above |
| Language | JavaScript | TypeScript |
| Type | Web framework | Web, Desktop & Mobile |
| Architecture | MVC | Component-based |
| Performance | Slower | Faster |
| Status | Deprecated | Actively maintained |


---
