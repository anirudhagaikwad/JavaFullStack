package app;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
private static final EntityManagerFactory entityManagerFactory;
static {
	try {
		entityManagerFactory=Persistence.createEntityManagerFactory("myPersistence");
	}catch(Throwable e) { throw new ExceptionInInitializerError(e);}
}

public static EntityManagerFactory getEntityManagerFactory() {
	return entityManagerFactory;
}
public static void shutDown() {
	if(entityManagerFactory!=null && entityManagerFactory.isOpen()) {
		entityManagerFactory.close();
	}
}
}//HibernateUtil
