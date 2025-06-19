package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Employee;

public class EmployeeDAO {
    private static volatile EmployeeDAO instance;
    private final SessionFactory sessionFactory;

    // Private constructor for singleton
    private EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Thread-safe singleton getInstance method
    public static EmployeeDAO getInstance(SessionFactory sessionFactory) {
        if (instance == null) {
            synchronized (EmployeeDAO.class) {
                if (instance == null) {
                    instance = new EmployeeDAO(sessionFactory);
                }
            }
        }
        return instance;
    }

    // Create
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(employee.getAddress());
            session.persist(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Read
    public Employee getEmployee(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Employee.class, id);
        }
    }

    // Update
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(employee.getAddress());
            session.merge(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Delete
    public void deleteEmployee(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.remove(employee.getAddress());
                session.remove(employee);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Employee", Employee.class).list();
        }
    }

    // Get employee by email
    public Employee getEmployeeByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Employee WHERE email = :email", Employee.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
}