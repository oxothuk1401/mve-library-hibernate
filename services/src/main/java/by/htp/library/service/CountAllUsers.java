package by.htp.library.service;

import by.htp.library.dao.Factory;
import by.htp.library.dao.HibernateUtil;
import by.htp.library.dao.UserOperationDAO;
import by.htp.library.dao.exception.DAOException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by oxothuk1401 on 18.10.2016.
 */
public final class CountAllUsers {

    public static int countAllUsers() {
        int countAllUsers = 0;
        Factory factory = Factory.getInstance();
        UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            countAllUsers = userOperationDAO.countAllUsers();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        transaction.commit();
        return countAllUsers;
    }
}
