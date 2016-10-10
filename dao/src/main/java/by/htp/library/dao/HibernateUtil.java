package by.htp.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by oxothuk1401 on 06.10.2016.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    public static final ThreadLocal local = new ThreadLocal();

    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory(){
        try {
            return  new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("SessionFactory creation failed." + e);
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
            Session session = (Session) local.get();
            if (session == null) {
                session = sessionFactory.openSession();
                local.set(session);
            }

            return session;
        }
    }