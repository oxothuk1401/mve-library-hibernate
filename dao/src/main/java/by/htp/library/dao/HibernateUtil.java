package by.htp.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by oxothuk1401 on 06.10.2016.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void sessionClose() {
        getSessionFactory().close();
    }

    public static Session openSession() {
        Session session = null;
        session = sessionFactory.openSession();
        return session;
    }

}
