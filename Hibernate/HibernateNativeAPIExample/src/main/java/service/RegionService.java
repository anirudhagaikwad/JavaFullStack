package service;

import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.HibernateUtil;


public class RegionService {

    public void createRegion(String regionName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Region region = new Region(regionName);
            session.persist(region);
            tx.commit();
            System.out.println("Region created: " + regionName);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error creating region: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public Region readRegion(int regionId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Region region = session.find(Region.class, regionId);
            if (region != null) {
                System.out.println("Region: " + region.getRegionName());
                region.getCountries().forEach(country ->
                        System.out.println("Country: " + country.getCountryName() + " (" + country.getCountryId() + ")"));
            } else {
                System.out.println("Region not found with ID: " + regionId);
            }
            return region;
        } catch (Exception e) {
            System.err.println("Error reading region: " + e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    public void updateRegion(int regionId, String newName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Region region = session.find(Region.class, regionId);
            if (region != null) {
                region.setRegionName(newName);
                session.merge(region);
                System.out.println("Region updated: " + newName);
            } else {
                System.out.println("Region not found with ID: " + regionId);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error updating region: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void deleteRegion(int regionId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Region region = session.find(Region.class, regionId);
            if (region != null) {
                session.remove(region);
                System.out.println("Region deleted with ID: " + regionId);
            } else {
                System.out.println("Region not found with ID: " + regionId);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error deleting region: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}