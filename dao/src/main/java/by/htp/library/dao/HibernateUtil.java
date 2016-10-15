package by.htp.library.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by oxothuk1401 on 06.10.2016.
 */
public class HibernateUtil {
    private static Logger log = Logger.getLogger(HibernateUtil.class.getName());
    private static final SessionFactory sessionFactory = buildSessionFactory();
    public static final ThreadLocal sessionlocal = new ThreadLocal();

    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            log.error("SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void sessionFactoryClose() {
        getSessionFactory().close();
    }

    public static Session getSession() {
        Session session = (Session) sessionlocal.get();
//        log.error("openAndSaveIntoLocal = " + session.hashCode());
        if (session == null) {
            session = sessionFactory.openSession();
            sessionlocal.set(session);
        }
        return session;
    }
}
