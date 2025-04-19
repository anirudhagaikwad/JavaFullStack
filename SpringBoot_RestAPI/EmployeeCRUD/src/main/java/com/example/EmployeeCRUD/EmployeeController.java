package com.example.EmployeeCRUD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService service;

    // Register Employee
    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) {
        logger.debug("Received request to register employee with email: {}", employee.getEmail());
        Employee savedEmployee = service.saveEmployee(employee);
        logger.debug("Successfully registered employee with ID: {}", savedEmployee.getEmpId());
        return ResponseEntity.ok(savedEmployee);
    }

    // Get All Employees
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.debug("Received request to get all employees");
        List<Employee> employees = service.getAllEmployees();
        logger.debug("Returning {} employees", employees.size());
        return ResponseEntity.ok(employees);
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        logger.debug("Received request to get employee with ID: {}", id);
        Optional<Employee> employee = service.getEmployeeById(id);
        if (employee.isPresent()) {
            logger.debug("Returning employee with ID: {}", id);
            return ResponseEntity.ok(employee.get());
        } else {
            logger.debug("Employee with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Get Employee by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
        logger.debug("Received request to get employee with email: {}", email);
        Optional<Employee> employee = service.getEmployeeByEmail(email);
        if (employee.isPresent()) {
            logger.debug("Returning employee with email: {}", email);
            return ResponseEntity.ok(employee.get());
        } else {
            logger.debug("Employee with email: {} not found", email);
            return ResponseEntity.notFound().build();
        }
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        logger.debug("Received request to update employee with ID: {}", id);
        Employee updatedEmployee = service.updateEmployee(id, employee);
        logger.debug("Successfully updated employee with ID: {}", id);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        logger.debug("Received request to delete employee with ID: {}", id);
        service.deleteEmployee(id);
        logger.debug("Successfully deleted employee with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}

/*
The `EmployeeController` class is a Spring MVC controller responsible for handling HTTP requests related to employee management. It interacts with the `EmployeeService` to perform CRUD operations and manages the flow between the web layer and the service layer.

1.Annotations:
   - `@Controller`: Marks this class as a Spring MVC controller, enabling it to handle HTTP requests.
   - `@RequestMapping("/employees")`: Maps HTTP requests starting with `/employees` to this controller.

2.Autowired Dependency:
   - `@Autowired` injects the `EmployeeService` into the controller, allowing it to use business logic defined in the service layer.

3.Constructor Injection:
   - `EmployeeController(EmployeeService employeeService)`: Constructor-based dependency injection ensures that the `EmployeeService` is provided to the controller.

### Methods

1.List Employees**:
   - `@GetMapping`: Handles GET requests to `/employees`.
   - Fetches a list of all employees from the service layer and adds it to the model.
   - Returns the name of the Thymeleaf template (`listEmp`) that displays the employee list.

2.Show Register Form:
   - `@GetMapping("/register")`: Handles GET requests to `/employees/register`.
   - Initializes a new `Employee` object and adds it to the model.
   - Returns the name of the Thymeleaf template (`registerEmp`) for registering a new employee.

3.Save Employee:
   - `@PostMapping("/save")`: Handles POST requests to `/employees/save`.
   - Saves a new employee using the service layer.
   - Redirects to `/employees` to display the updated list of employees.

4.Show Edit Form:
   - `@GetMapping("/edit/{id}")`: Handles GET requests to `/employees/edit/{id}`.
   - Retrieves an existing employee by ID and adds it to the model.
   - Returns the name of the Thymeleaf template (`registerEmp`) for editing the employee.

5.Update Employee:
   - `@PostMapping("/update/{id}")`: Handles POST requests to `/employees/update/{id}`.
   - Retrieves the existing employee by ID, updates its fields with new data, and saves the updated employee.
   - Redirects to `/employees` to display the updated list.

6.Delete Employee:
   - `@GetMapping("/delete/{id}")`: Handles GET requests to `/employees/delete/{id}`.
   - Deletes the employee by ID using the service layer.
   - Redirects to `/employees` to display the updated list.

### Purpose
- Separation of Concerns: The controller handles HTTP requests and responses, while the service layer manages business logic. This separation keeps the code organized and modular.
- Data Binding: `@ModelAttribute` is used to bind form data to the `Employee` object.
- Redirection: After performing operations like save, update, or delete, the controller redirects to `/employees` to refresh the employee list view.

This approach ensures that the web layer (controller) is clean and focused on handling user interactions, while the service layer deals with business logic and data manipulation. 
 
The EmployeeController class defines a REST API with the following endpoints under the base path /employees:

POST /employees/register
Purpose: Registers a new employee.
Method: POST
Input: Employee object in the request body.
Output: ResponseEntity<Employee> with the saved employee.

GET /employees/all
Purpose: Retrieves a list of all employees.
Method: GET
Output: ResponseEntity<List<Employee>> with the list of employees.

GET /employees/{id}
Purpose: Retrieves an employee by their ID.
Method: GET
Input: id as a path variable.
Output: ResponseEntity<Employee> with the employee or 404 if not found.

GET /employees/email/{email}
Purpose: Retrieves an employee by their email.
Method: GET
Input: email as a path variable.
Output: ResponseEntity<Employee> with the employee or 404 if not found.

PUT /employees/update/{id}
Purpose: Updates an existing employee.
Method: PUT
Input: id as a path variable, Employee object in the request body.
Output: ResponseEntity<Employee> with the updated employee.

DELETE /employees/delete/{id}
Purpose: Deletes an employee by their ID.
Method: DELETE
Input: id as a path variable.
Output: ResponseEntity<Void> with no content (204 status).
Total Endpoints: 6
*/