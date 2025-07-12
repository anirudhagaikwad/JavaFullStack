package service;

import entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import app.HibernateUtil;

import java.sql.Date;
import java.util.List;

public class EmployeeService {
    private final EntityManagerFactory emf;

    public EmployeeService() {
        this.emf = HibernateUtil.getEntityManagerFactory();
    }

    // Create
    public void createEmployee(String firstName, String lastName, String email, Date hireDate) {
        EntityTransaction transaction = null;
        EntityManager entityManager = emf.createEntityManager();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            EmployeeEntity employee = new EmployeeEntity();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setHireDate(hireDate);
            entityManager.persist(employee);
            transaction.commit();
            System.out.println("Created employee with ID: " + employee.getEmp_id());
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    // Read by ID
    public EmployeeEntity findEmployee(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.find(EmployeeEntity.class, id);
        } finally {
            entityManager.close();
        }
    }

    // Read all
    public List<EmployeeEntity> findAllEmployees() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            TypedQuery<EmployeeEntity> query = entityManager.createQuery("FROM EmployeeEntity", EmployeeEntity.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    // Update
    public void updateEmployee(int id, String firstName, String lastName, String email, Date hireDate) {
        EntityTransaction transaction = null;
        EntityManager entityManager = emf.createEntityManager();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            EmployeeEntity employee = entityManager.find(EmployeeEntity.class, id);
            if (employee != null) {
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setHireDate(hireDate);
                entityManager.merge(employee);
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
        } finally {
            entityManager.close();
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        EntityTransaction transaction = null;
        EntityManager entityManager = emf.createEntityManager();
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            EmployeeEntity employee = entityManager.find(EmployeeEntity.class, id);
            if (employee != null) {
                entityManager.remove(employee);
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
        } finally {
            entityManager.close();
        }
    }

    // Shutdown
    public void shutdown() {
        HibernateUtil.shutDown();
    }
}