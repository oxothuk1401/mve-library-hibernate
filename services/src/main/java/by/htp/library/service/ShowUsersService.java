package by.htp.library.service;

import by.htp.library.dao.Factory;
import by.htp.library.dao.HibernateUtil;
import by.htp.library.dao.UserOperationDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import java.util.List;

public final class ShowUsersService {
    private static Logger log = Logger.getLogger(ShowUsersService.class.getName());

    public final static List<User> showUsers() throws DAOException {
        List result = null;
        Factory factory = Factory.getInstance();
        UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
        Session session = HibernateUtil.getSession();
        log.info("session_showUsers_service = " + session.hashCode());
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = userOperationDAO.getAll();
            log.info("session_showUsers_service_return = " + session.hashCode());
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
