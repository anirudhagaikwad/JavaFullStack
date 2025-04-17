# AngularTutorial

This project is an Angular 19 application demonstrating key Angular features, including components, Angular Material, and the Component Dev Kit (CDK). 

## Prerequisites
Before you begin, ensure you have the following installed:

- **Node.js**: Version 22 or later
- **Angular CLI**: Install globally with `npm install -g @angular/cli@19`

## Setup Instructions

1. **Create a New Angular Project**:

   ```bash
   ng new angularTutorial --style=css --routing=true --standalone=true
   cd angularTutorial
   ```

2. **Install Angular CDK**:

   ```bash
   npm install @angular/cdk
   ```

3. **Install Angular Material**:

   ```bash
   npm install @angular/material
   ```

   Alternatively, use the Angular CLI schematic to automate setup:

   ```bash
   ng add @angular/material
   ```

   This will:

   - Install Angular Material, CDK, and animations packages
   - Configure global styles and themes
   - Update `angular.json` with necessary configurations

4. **Generate Components**:

   ```bash
   ng generate component Hello
   ng generate component Controlflow
   ng generate component Signal
   ng generate component Minigame
   ```

## Development Server

Run the local development server:

```bash
ng serve
```

Open `http://localhost:4200/` in your browser. The app will auto-reload on source file changes.

List all available schematics:

```bash
ng generate --help
```

## Building the Project

Build the project for production:

```bash
ng build
```

Build artifacts will be saved in the `dist/` directory, optimized for performance.

## Running Unit Tests

Run unit tests with Karma:

```bash
ng test
```

## Running End-to-End Tests

Run end-to-end (e2e) tests:

```bash
ng e2e
```

Note: Angular CLI does not include an e2e testing framework by default. Consider using Cypress or Playwright.

## Additional Resources

- Angular CLI Overview and Command Reference
- Angular Material Documentation
- Angular CDK Documentation

