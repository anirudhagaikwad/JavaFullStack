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
## 16. **Angular Signals**, **CommonModule**, **FormsModule**, and **NgModule**

### **1. Angular Signals**
#### **What is it?**
- **Signals** are a reactive primitive in Angular (introduced in Angular 17) that represent a value and notify consumers when that value changes. They are designed to make change detection more efficient by tracking state usage granularly.[](https://blog.angular-university.io/angular-signals/)
- **Types**:
  - **Writable Signals**: Created using `signal(value)`; can be updated with `.set()` or `.update()`. Example: `const count = signal(0); count.set(5);`[](https://angular.dev/guide/signals)
  - **Computed Signals**: Read-only signals derived from other signals using `computed()`. Example: `const doubleCount = computed(() => count() * 2);`[](https://angular.dev/guide/signals)
- Signals are consumed via data binding in templates or programmatically via their getter functions (e.g., `count()`).[](https://www.angulararchitects.io/blog/angular-signals/)
- They are "glitch-free," preventing interim state issues during rapid updates.[](https://www.angulararchitects.io/blog/angular-signals/)

#### **Purpose**
- **Reactivity**: Signals allow Angular to track where state is used, enabling precise updates only to affected parts of the UI, improving performance over traditional change detection.[](https://blog.angular-university.io/angular-signals/)
- **Optimization**: In OnPush components, signals trigger change detection efficiently when their values change.[](https://www.angulararchitects.io/blog/angular-signals/)
- **Simplicity**: Provide an easy-to-use API for reactive programming, preparing Angular for signal-based components (expected around Angular 17.2).[](https://blog.angular-university.io/angular-signals/)
- **Future-Proofing**: Signals are set to integrate deeply with Angular’s change detection system, reducing unnecessary checks.[](https://blog.angular-university.io/angular-signals/)

---

### **2. CommonModule**
#### **What is it?**
- **CommonModule** is an Angular module that provides essential directives for templating, such as `*ngIf`, `*ngFor`, and `ngStyle`. It is a subset of `BrowserModule`, which includes `CommonModule` and browser-specific features.[](https://blog.angular-university.io/angular2-ngmodule/)
- It must be explicitly imported in feature modules (not the root module, which uses `BrowserModule`) to use these directives.[](https://blog.angular-university.io/angular2-ngmodule/)

#### **Purpose**
- **Template Functionality**: Enables core Angular directives for conditional rendering (`*ngIf`), iteration (`*ngFor`), and styling (`ngStyle`), making it essential for most feature modules.[](https://blog.angular-university.io/angular2-ngmodule/)
- **Modularity**: Allows feature modules to access common directives without importing the heavier `BrowserModule`, which is reserved for the root module.[](https://medium.com/%40cyrilletuzi/understanding-angular-modules-ngmodule-and-their-scopes-81e4ed6f7407)
- **Scoped Usage**: Ensures directives are only available in modules that import `CommonModule`, maintaining encapsulation.[](https://blog.angular-university.io/angular2-ngmodule/)

---

### **3. FormsModule**
#### **What is it?**
- **FormsModule** is an Angular module that provides directives and services for template-driven forms, such as `ngModel`, `ngForm`, and form validation directives.[](https://www.angulararchitects.io/blog/angular-signals/)
- It is distinct from `ReactiveFormsModule`, which supports reactive forms.[](https://www.reddit.com/r/Angular2/comments/17puc4p/what_is_the_purpose_of_angular_modules/)
- Example usage in a template:
  ```html
  <form #form="ngForm">
    <input [(ngModel)]="from" name="from">
  </form>
  ```[](https://www.angulararchitects.io/blog/angular-signals/)

#### **Purpose**
- **Template-Driven Forms**: Simplifies form creation by allowing two-way data binding with `ngModel` and automatic form state management with `ngForm`.[](https://www.angulararchitects.io/blog/angular-signals/)
- **Ease of Use**: Ideal for simple forms where reactive forms’ explicit control is unnecessary.[](https://angular.dev/overview)
- **Future Integration**: The Angular team plans to adapt form handling to signals, enhancing reactivity (e.g., updating form state via signals).[](https://www.angulararchitects.io/blog/angular-signals/)

---

### **4. NgModule**
#### **What is it?**
- **NgModule** is a class decorated with `@NgModule` that organizes Angular applications into cohesive blocks of functionality. It defines a compilation context and dependency injection scope.[](https://angular.dev/guide/ngmodules/overview)
- **Key Metadata**:
  - **declarations**: Lists components, directives, and pipes belonging to the module (non-standalone).[](https://angular.dev/guide/ngmodules/overview)
  - **imports**: Includes other modules or standalone components/directives/pipes needed by the module.[](https://angular.dev/guide/ngmodules/overview)
  - **exports**: Makes declared or imported components/directives/pipes available to other modules.[](https://angular.dev/guide/ngmodules/overview)
  - **providers**: Defines services (globally scoped unless overridden).[](https://medium.com/%40cyrilletuzi/understanding-angular-modules-ngmodule-and-their-scopes-81e4ed6f7407)
  - **bootstrap**: Specifies the root component for the root module.[](https://stackoverflow.com/questions/40393701/what-is-ngmodule-actually-in-angular)
- Example:
  ```typescript
  import { NgModule } from '@angular/core';
  import { CommonModule } from '@angular/common';
  import { CustomComponent } from './custom.component';
  @NgModule({
    declarations: [CustomComponent],
    imports: [CommonModule],
    exports: [CustomComponent]
  })
  export class CustomModule { }
  ```[](https://www.tutorialspoint.com/angular/angular-introduction-to-modules.htm)

#### **Purpose**
- **Organization**: Groups related components, directives, pipes, and services into logical units (e.g., `WishlistModule`, `CartModule`).[](https://stackoverflow.com/questions/40393701/what-is-ngmodule-actually-in-angular)
- **Modularity**: Enables lazy loading to split applications into smaller, load-on-demand chunks, improving performance.[](https://blog.angular-university.io/angular2-ngmodule/)
- **Dependency Injection**: Configures services and providers for the module’s scope.[](https://angular.dev/guide/ngmodules/overview)
- **Compilation Context**: Defines how templates are compiled, supporting ahead-of-time (AOT) compilation for faster rendering.[](https://blog.angular-university.io/angular2-ngmodule/)
- **Transition to Standalone**: While NgModules are still supported, Angular recommends standalone components for new code to simplify dependency management.[](https://angular.dev/guide/ngmodules/overview)[](https://www.reddit.com/r/Angular2/comments/17puc4p/what_is_the_purpose_of_angular_modules/)

---

### **Key Notes**
- **Signals vs. NgModule**: Signals are a new reactive primitive focused on state management and change detection, while NgModules focus on organizing code and dependencies. Signals will likely power future Angular features, reducing reliance on NgModules.[](https://blog.angular-university.io/angular-signals/)
- **CommonModule vs. FormsModule**: `CommonModule` provides core templating directives, while `FormsModule` adds form-specific functionality. Both are often imported together in feature modules.[](https://blog.angular-university.io/angular2-ngmodule/)[](https://www.angulararchitects.io/blog/angular-signals/)
- **Standalone Components**: Angular is moving toward standalone components, which import dependencies directly, reducing the need for NgModules. However, NgModules remain relevant for legacy code and certain advanced scenarios like lazy loading.[](https://www.reddit.com/r/Angular2/comments/17puc4p/what_is_the_purpose_of_angular_modules/)

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
