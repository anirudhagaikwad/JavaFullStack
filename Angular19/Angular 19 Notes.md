## 🌟 Angular 19 Notes

### 📌 1. Introduction to Angular
- Angular is a TypeScript-based open-source web application framework.
- Developed by Google.
- Used for building single-page applications (SPAs).

---

### 🏗️ 2. Angular Architecture
- Modules: Group components, directives, pipes, and services.
- Components: Core building blocks controlling parts of the UI.
- Templates: HTML + Angular syntax (interpolation, directives).
- Services: Logic that can be shared across components.
- Dependency Injection: Inject services into components or other services.
- Routing: Navigates between components/pages.

---

### ⚙️ 3. Angular CLI
- Command-line interface to create and manage Angular apps.
- Key commands:
  - `ng new` – Create a new project
  - `ng serve` – Start development server
  - `ng generate component/service/module` – Create resources
  - `ng build` – Compile for production

---

### 🧱 4. Components
- Components are the building blocks of the UI.
- Decorated with `@Component` decorator.
- Each component includes:
  - Selector: The custom HTML tag name used to place the component.
  - Template: The HTML layout or structure.
  - Style: CSS or SCSS styles applied to the component.
  - Class: TypeScript class that defines logic, data, and behavior.
- Components make up views and are used inside templates.

---

### 🔁 5. Data Binding (4 Types)
- Binding connects component logic with templates (UI).
1. Interpolation – `{{ expression }}` (Displays dynamic data)
2. Property Binding – `[property]="expression"` (Sets element properties)
3. Event Binding – `(event)="handlerFunction()"` (Responds to events like click)
4. Two-way Binding – `[(ngModel)]="property"` (Syncs data both ways; needs `FormsModule`)

---

### 🎯 6. Directives
- Directives are instructions in templates to manipulate DOM or behavior.
- Structural Directives:
  - Change layout by adding/removing elements.
  - Examples: `*ngIf` (condition), `*ngFor` (loop)
- Attribute Directives:
  - Change appearance or behavior of an element.
  - Examples: `[ngClass]`, `[ngStyle]`
  - You can also create custom attribute directives.

---

### 🧭 7. Routing
- Routing helps navigate between views/components.
- Defined in `app-routing.module.ts` using `RouterModule`.
- Each route has a `path` and a `component`.
- Supports:
  - Route parameters (dynamic values)
  - Route guards (protect routes)
  - Lazy loading (load modules on demand for better performance)

---

### 🗃️ 8. Modules
- Modules group related parts of the app (components, services, etc.).
- The main module is `AppModule` (root module).
- Feature modules organize big apps into smaller sections.
- Defined using `@NgModule` decorator.

---

### 📦 9. Services and Dependency Injection
- Services are used to write business logic, reusable code, or data access.
- Created using Angular CLI: `ng generate service service-name`
- Injected into components via constructor using Angular’s Dependency Injection system.
- Promotes code reuse and separation of concerns.

---

### 🌐 10. HTTP Client
- Used to make HTTP requests to a backend (like REST APIs).
- Angular provides `HttpClientModule`.
- Use `HttpClient` to make requests (GET, POST, PUT, DELETE).
- Works with Observables (asynchronous operations).

---

### ✅ 11. Forms
- Used to get user input.
- Two types:
  - Template-driven Forms: Simple forms using `[(ngModel)]`.
  - Reactive Forms: More complex and powerful using `FormGroup`, `FormControl`, and `FormBuilder`.

---

### 🧪 12. Testing
- Angular supports unit testing and end-to-end testing.
- Tools:
  - Jasmine: Testing framework.
  - Karma: Test runner.
- You can test components, services, pipes, and directives.

---

### 🧰 13. Build and Deployment
- Use `ng build --prod` to create optimized files for production.
- Files are stored in the `dist/` folder.
- Can be deployed to platforms like Firebase, Netlify, or GitHub Pages.

---

### 🔄 14. Lifecycle Hooks
- Lifecycle hooks are methods that run at different stages of a component's life.
- Examples:
  - `ngOnInit()` – Runs after component is initialized.
  - `ngOnChanges()` – Called when input properties change.
  - `ngOnDestroy()` – Called just before Angular destroys the component.
- Used for setup, cleanup, reacting to changes, etc.

---

### 🆕 15. What’s New in Angular 19
- Signals – A new way to track and react to reactive values.
- Improved SSR Hydration – Better server-side rendering and rehydration.
- Vite Support – Fast dev server and build system.
- Build Performance – Improved speed and memory efficiency.
- Angular CLI Improvements – Faster and smarter commands.
- RxJS Compatibility – Updated for modern RxJS features.

---

### 🎯prerequisite Angular19 : 
    Downloads Node.js v22.14.0
    Text editor - recommend Visual Studio Code
    Terminal - Required for running Angular CLI commands
    Development Tool - To improve your development workflow, recommend the Angular Language Service
    https://code.visualstudio.com/

### 🎯Install Angular CLI
    npm install -g @angular/cli  

### 🎯Check Angular Version
    ng version

### 🎯Install Angular Material 
    ng add @angular/material

---

### 🎯What is Angular?

Angular is a framework and development platform, built on TypeScript. It is used for creating single-page web applications. As a platform, Angular includes:
    A component-based framework for building scalable web applications
    A collection of well-integrated libraries that cover a wide variety of features, including routing, forms management, client-server communication, and more
    A suite of developer tools to help you develop, build, test, and update your code


### 🎯The Angular CLI is the fastest, easiest, and recommended way to develop Angular applications. 
The Angular CLI makes a number of tasks easy. Here are some example commands that you'll use frequently:

Command 	Description
---------------------------------------------------------------
ng build 	Compiles an Angular app into an output directory.
ng serve 	Builds and serves your application, rebuilding on file changes.
ng generate Generates or modifies files based on a schematic.
ng test 	Runs unit tests on a given project.
ng e2e  	Builds and serves an Angular application, then runs end-to-end tests.

Create a new project
    ng new <project-name>


### 🎯Understanding Angular directory structure
The angular project contains so many pre defined directories and files.
Angular Directory Structure

 APP 
     ngApp 
         .angular 
         .vscode 
         node_modules 
         src
         .editorconfig
         .gitignore
        {} angular.json
        {} package-lock.json
        {} package.json
         README.md
        {} tsconfig.app.json
        TS tsconfig.json
        {} tsconfig.spec.json

APP is the name of parent directory on our desktop. 
Remaining all things are build by Angular CLI. We have to focus on src folder in ngApp. 
Our main application is inside src folder. src folder is the source code of project and it includes components, index.html file, stylesheets etc.
Root Folder Content
File/Folder	     Whats inside
---------------------------------
e2e	            end to end testing
node_modules	folder for node dependencies
src	folder      for project source code
.angular	    webpack and babel
package.json	node dependencies configuration file
angular.json	angular configuration file

The application source files that this tutorial focuses on are in src/app:

src/app
├── app.component.css
├── app.component.html
├── app.component.spec.ts
├── app.component.ts
└── app.config.ts

### 🎯Key files that the CLI generates automatically are the following:

    app.component.ts: Also known as the class, contains the logic for the application's main page.
    app.component.html: Contains the HTML for AppComponent. The contents of this file are also known as the template. The template determines the view or what you see in the browser.
    app.component.css: Contains the styles for AppComponent. You use this file when you want to define styles that only apply to a specific component, as opposed to your application overall.

A component in Angular is made up of three main parts—the template, styles, and the class. 
For example, app.component.ts, app.component.html, and app.component.css together constitute the AppComponent. 
This structure separates the logic, view, and styles so that the application is more maintainable and scalable. 

---

### 🎯AngularJS to Angular
    AngularJS is basically 1.x Version which was launched in 2010 but 
    Angular without JS represents Angular 2 and 2+ Version like Angular 2 ( beta), 
    Angular 4 to 18. Angular which is released after AngularJS is not updated version of AngularJS but its Re-Written form of AngularJS. 
    Angular is faster than AngularJS. AngularJS is only Web based Framework but Angular is Web, Desktop and Mobile Application based Framework and development platform.          

