package com.example.EmployeeCRUD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository repository;

    // Create Employee
    public Employee saveEmployee(Employee employee) {
        logger.debug("Attempting to save employee with email: {}", employee.getEmail());
        Employee savedEmployee = repository.save(employee);
        logger.debug("Successfully saved employee with ID: {}", savedEmployee.getEmpId());
        return savedEmployee;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        logger.debug("Retrieving all employees");
        List<Employee> employees = repository.findAll();
        logger.debug("Found {} employees", employees.size());
        return employees;
    }

    // Get Employee by ID
    public Optional<Employee> getEmployeeById(Integer id) {
        logger.debug("Retrieving employee with ID: {}", id);
        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()) {
            logger.debug("Found employee with ID: {}", id);
        } else {
            logger.debug("No employee found with ID: {}", id);
        }
        return employee;
    }

    // Get Employee by Email
    public Optional<Employee> getEmployeeByEmail(String email) {
        logger.debug("Retrieving employee with email: {}", email);
        Optional<Employee> employee = repository.findByEmail(email);
        if (employee.isPresent()) {
            logger.debug("Found employee with email: {}", email);
        } else {
            logger.debug("No employee found with email: {}", email);
        }
        return employee;
    }

    // Update Employee
    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        logger.debug("Attempting to update employee with ID: {}", id);
        return repository.findById(id)
                .map(employee -> {
                    logger.debug("Found employee with ID: {}, updating details", id);
                    employee.setFirstName(updatedEmployee.getFirstName());
                    employee.setLastName(updatedEmployee.getLastName());
                    employee.setEmail(updatedEmployee.getEmail());
                    employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
                    employee.setHireDate(updatedEmployee.getHireDate());
                    employee.setSalary(updatedEmployee.getSalary());
                    Employee savedEmployee = repository.save(employee);
                    logger.debug("Successfully updated employee with ID: {}", id);
                    return savedEmployee;
                })
                .orElseThrow(() -> {
                    logger.debug("Failed to update - employee not found with ID: {}", id);
                    return new RuntimeException("Employee not found with ID: " + id);
                });
    }

    // Delete Employee
    public void deleteEmployee(Integer id) {
        logger.debug("Attempting to delete employee with ID: {}", id);
        repository.deleteById(id);
        logger.debug("Successfully deleted employee with ID: {}", id);
    }
}