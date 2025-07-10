package service;


import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.HibernateUtil;


public class CountryService {

    public void createCountry(String countryId, String countryName, int regionId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Region region = session.find(Region.class, regionId);
            if (region != null) {
                Country country = new Country(countryId, countryName, region);
                region.addCountry(country);
                session.persist(country);
                tx.commit();
                System.out.println("Country created: " + countryName);
            } else {
                System.out.println("Region not found with ID: " + regionId);
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error creating country: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public Country readCountry(String countryId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Country country = session.find(Country.class, countryId);
            if (country != null) {
                System.out.println("Country: " + country.getCountryName() +
                        ", Region: " + country.getRegion().getRegionName());
            } else {
                System.out.println("Country not found with ID: " + countryId);
            }
            return country;
        } catch (Exception e) {
            System.err.println("Error reading country: " + e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    public void updateCountry(String countryId, String newName, int newRegionId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Country country = session.find(Country.class, countryId);
            Region region = session.find(Region.class, newRegionId);
            if (country != null && region != null) {
                country.setCountryName(newName);
                country.setRegion(region);
                session.merge(country);
                System.out.println("Country updated: " + newName);
            } else {
                System.out.println("Country or Region not found");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error updating country: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    public void deleteCountry(String countryId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Country country = session.find(Country.class, countryId);
            if (country != null) {
                session.remove(country);
                System.out.println("Country deleted with ID: " + countryId);
            } else {
                System.out.println("Country not found with ID: " + countryId);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("Error deleting country: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}