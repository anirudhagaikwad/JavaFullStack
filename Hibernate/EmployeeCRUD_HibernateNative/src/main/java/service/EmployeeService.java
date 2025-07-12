package service;

import entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import app.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class EmployeeService {
    private final SessionFactory sessionFactory;

    public EmployeeService() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    // Create
    public void createEmployee(String firstName, String lastName, String email, Date hireDate) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            EmployeeEntity employee = new EmployeeEntity();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setHireDate(hireDate);
            session.persist(employee);
            transaction.commit();
            System.out.println("Created employee with ID: " + employee.getEmp_id());
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Read by ID
    public EmployeeEntity findEmployee(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(EmployeeEntity.class, id);
        }
    }

    // Read all
    public List<EmployeeEntity> findAllEmployees() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM EmployeeEntity", EmployeeEntity.class).list();
        }
    }

    // Update
    public void updateEmployee(int id, String firstName, String lastName, String email, Date hireDate) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            EmployeeEntity employee = session.get(EmployeeEntity.class, id);
            if (employee != null) {
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setHireDate(hireDate);
                session.merge(employee);
                transaction.commit();
                System.out.println("Updated employee with ID: " + id);
            } else {
                System.out.println("Employee with ID " + id + " not found");
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            EmployeeEntity employee = session.get(EmployeeEntity.class, id);
            if (employee != null) {
                session.remove(employee);
                transaction.commit();
                System.out.println("Deleted employee with ID: " + id);
            } else {
                System.out.println("Employee with ID " + id + " not found");
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Shutdown
    public void shutdown() {
        HibernateUtil.shutdown();
    }
}
