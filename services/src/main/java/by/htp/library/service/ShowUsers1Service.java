package by.htp.library.service;

import by.htp.library.dao.Factory;
import by.htp.library.dao.HibernateUtil;
import by.htp.library.dao.UserOperationDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import java.util.List;

/**
 * Created by oxothuk1401 on 18.10.2016.
 */
public final class ShowUsers1Service {

    public final static List<User> showUsers1(String position, String amount){

        List result = null;
        Factory factory = Factory.getInstance();
        UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            try {
                result = userOperationDAO.takeUser(position,amount);
            } catch (DAOException e) {
                e.printStackTrace();
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new TransactionException("");
        }
        return result;
    }
}