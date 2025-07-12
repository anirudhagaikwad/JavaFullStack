package app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static final SessionFactory sessionFactory;
static {
	try {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}catch(Throwable e) { throw new ExceptionInInitializerError(e);}
}

public static SessionFactory getSessionFactory() {
	return sessionFactory;
}

public static void shutdown() {
    if (sessionFactory != null && !sessionFactory.isClosed()) {
        sessionFactory.close();
    }
}
}//HibernateUtil
