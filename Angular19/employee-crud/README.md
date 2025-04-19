# EmployeeCrud

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 19.2.2.

## Angular 19 Project Setup

#### Prerequisites
- Node.js (v20 or later)
- Angular CLI: `npm install -g @angular/cli@19`
- Spring Boot 3.4.4 backend running at `http://localhost:8080/employees`
- Maven (for backend CORS configuration, if needed)

#### Setup Commands
```bash
# Create new Angular project
ng new employee-crud --style=css --routing=true --standalone=true
cd employee-crud

# Install Bootstrap 5.3.5
npm install bootstrap@5.3.5

# Generate components
ng generate component components/employee-list
ng generate component components/employee-form
ng generate component components/employee-detail

# Generate service
ng generate service services/employee

# Generate model
ng generate interface models/employee
```

#### Update `angular.json`
Add Bootstrap to `angular.json` under `projects.employee-crud.architect.build.options`:
```json
"styles": [
  "node_modules/bootstrap/dist/css/bootstrap.min.css",
  "src/styles.css"
],
"scripts": [
  "node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
]
```

#### CORS Configuration (Spring Boot)
Ensure your Spring Boot backend allows requests from `http://localhost:4200`. Add this to your Spring Boot application:

```java
package com.example.EmployeeCRUD;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");
            }
        };
    }
}
```

