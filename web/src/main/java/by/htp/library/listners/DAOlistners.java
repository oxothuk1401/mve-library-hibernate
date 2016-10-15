//package by.htp.library.listners;
//
//import by.htp.library.dao.HibernateUtil;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//
///**
// * Created by oxothuk1401 on 15.10.2016.
// */
//public class DAOlistners implements ServletContextListener {
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        HibernateUtil.getSessionFactory().openSession();
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//        HibernateUtil.sessionFactoryClose();
//    }
//}
