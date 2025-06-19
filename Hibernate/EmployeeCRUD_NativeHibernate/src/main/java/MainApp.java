import model.Address;
import model.Employee;
import util.HibernateUtil;
import java.util.Scanner;
import dao.EmployeeDAO;
import java.util.List;


public class MainApp {
    private static Scanner scanner;
    private static EmployeeDAO employeeDAO;

    public static void main(String[] args) {
        try {
            // Initialize Scanner and EmployeeDAO
            scanner = new Scanner(System.in);
            employeeDAO = EmployeeDAO.getInstance(HibernateUtil.getSessionFactory());

            while (true) {
                displayMenu();
                int choice = getUserChoice();
                if (choice == 7) break;
                processChoice(choice);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Ensure resources are closed
            HibernateUtil.shutdown();
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Employee Management System ===");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. View All Employees");
        System.out.println("6. Find Employee by Email");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            String input = scanner.nextLine().trim();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return -1;
        }
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                addEmployee();
                break;
            case 2:
                viewEmployee();
                break;
            case 3:
                updateEmployee();
                break;
            case 4:
                deleteEmployee();
                break;
            case 5:
                viewAllEmployees();
                break;
            case 6:
                findEmployeeByEmail();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void addEmployee() {
        System.out.println("\n=== Add New Employee ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty() || !email.contains("@")) {
            System.out.println("Invalid email format.");
            return;
        }

        System.out.print("Enter city: ");
        String city = scanner.nextLine().trim();
        if (city.isEmpty()) {
            System.out.println("City cannot be empty.");
            return;
        }

        System.out.print("Enter state: ");
        String state = scanner.nextLine().trim();
        if (state.isEmpty()) {
            System.out.println("State cannot be empty.");
            return;
        }

        System.out.print("Enter zip code: ");
        String zipCode = scanner.nextLine().trim();
        if (zipCode.isEmpty()) {
            System.out.println("Zip code cannot be empty.");
            return;
        }

        Address address = new Address(city, state, zipCode);
        Employee employee = new Employee(name, email, address);
        employeeDAO.saveEmployee(employee);
        System.out.println("Employee added successfully!");
    }

    private static void viewEmployee() {
        System.out.print("\nEnter employee ID: ");
        try {
            String input = scanner.nextLine().trim();
            Integer id = Integer.parseInt(input);
            Employee employee = employeeDAO.getEmployee(id);
            System.out.println(employee != null ? employee : "Employee not found!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format! Please enter a valid number.");
        }
    }

    private static void updateEmployee() {
        System.out.print("\nEnter employee ID to update: ");
        try {
            String input = scanner.nextLine().trim();
            Integer id = Integer.parseInt(input);
            Employee employee = employeeDAO.getEmployee(id);
            if (employee == null) {
                System.out.println("Employee not found!");
                return;
            }

            System.out.print("Enter new name (leave blank to keep '" + employee.getName() + "'): ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) employee.setName(name);

            System.out.print("Enter new email (leave blank to keep '" + employee.getEmail() + "'): ");
            String email = scanner.nextLine().trim();
            if (!email.isEmpty()) {
                if (!email.contains("@")) {
                    System.out.println("Invalid email format. Update aborted.");
                    return;
                }
                employee.setEmail(email);
            }

            System.out.print("Enter new city (leave blank to keep '" + employee.getAddress().getCity() + "'): ");
            String city = scanner.nextLine().trim();
            if (!city.isEmpty()) employee.getAddress().setCity(city);

            System.out.print("Enter new state (leave blank to keep '" + employee.getAddress().getState() + "'): ");
            String state = scanner.nextLine().trim();
            if (!state.isEmpty()) employee.getAddress().setState(state);

            System.out.print("Enter new zip code (leave blank to keep '" + employee.getAddress().getZipCode() + "'): ");
            String zipCode = scanner.nextLine().trim();
            if (!zipCode.isEmpty()) employee.getAddress().setZipCode(zipCode);

            employeeDAO.updateEmployee(employee);
            System.out.println("Employee updated successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format! Please enter a valid number.");
        }
    }

    private static void deleteEmployee() {
        System.out.print("\nEnter employee ID to delete: ");
        try {
            String input = scanner.nextLine().trim();
            Integer id = Integer.parseInt(input);
            Employee employee = employeeDAO.getEmployee(id);
            if (employee == null) {
                System.out.println("Employee not found!");
                return;
            }
            employeeDAO.deleteEmployee(id);
            System.out.println("Employee deleted successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format! Please enter a valid number.");
        }
    }

    private static void viewAllEmployees() {
        System.out.println("\n=== All Employees ===");
        List<Employee> employees = employeeDAO.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            employees.forEach(System.out::println);
        }
    }

    private static void findEmployeeByEmail() {
        System.out.print("\nEnter employee email: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty() || !email.contains("@")) {
            System.out.println("Invalid email format.");
            return;
        }
        Employee employee = employeeDAO.getEmployeeByEmail(email);
        System.out.println(employee != null ? employee : "Employee not found!");
    }
}