package app;

import entity.EmployeeEntity;
import service.EmployeeService;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add New Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View Employee by ID");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1: // Add New Employee
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Hire Date (YYYY-MM-DD): ");
                    String hireDateStr = scanner.nextLine();
                    Date hireDate;
                    try {
                        hireDate = Date.valueOf(hireDateStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid date format. Use YYYY-MM-DD.");
                        break;
                    }
                    service.createEmployee(firstName, lastName, email, hireDate);
                    break;

                case 2: // Update Employee
                    System.out.print("Enter Employee ID to update: ");
                    int updateId;
                    try {
                        updateId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID format.");
                        break;
                    }
                    System.out.print("Enter New First Name: ");
                    String newFirstName = scanner.nextLine();
                    System.out.print("Enter New Last Name: ");
                    String newLastName = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter New Hire Date (YYYY-MM-DD): ");
                    String newHireDateStr = scanner.nextLine();
                    Date newHireDate;
                    try {
                        newHireDate = Date.valueOf(newHireDateStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid date format. Use YYYY-MM-DD.");
                        break;
                    }
                    service.updateEmployee(updateId, newFirstName, newLastName, newEmail, newHireDate);
                    break;

                case 3: // Delete Employee
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId;
                    try {
                        deleteId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID format.");
                        break;
                    }
                    service.deleteEmployee(deleteId);
                    break;

                case 4: // View Employee by ID
                    System.out.print("Enter Employee ID to view: ");
                    int viewId;
                    try {
                        viewId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID format.");
                        break;
                    }
                    EmployeeEntity emp = service.findEmployee(viewId);
                    if (emp != null) {
                        System.out.println("ID: " + emp.getEmp_id() + ", Name: " + emp.getFirstName() + " " + 
                                          emp.getLastName() + ", Email: " + emp.getEmail() + ", Hire Date: " + 
                                          emp.getHireDate());
                    } else {
                        System.out.println("Employee with ID " + viewId + " not found.");
                    }
                    break;

                case 5: // View All Employees
                    List<EmployeeEntity> employees = service.findAllEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        System.out.println("\nAll Employees:");
                        for (EmployeeEntity e : employees) {
                            System.out.println("ID: " + e.getEmp_id() + ", Name: " + e.getFirstName() + " " + 
                                              e.getLastName() + ", Email: " + e.getEmail() + ", Hire Date: " + 
                                              e.getHireDate());
                        }
                    }
                    break;

                case 6: // Exit
                    running = false;
                    service.shutdown();
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }
}
