package by.htp.library.service;

import by.htp.library.dao.Factory;
import by.htp.library.dao.HibernateUtil;
import by.htp.library.dao.UserOperationDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import by.htp.library.service.exception.ServiceException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

public final class UserService {
    public final static User checkLogin(String login, String password) throws ServiceException, DAOException {
        if (!Validator.loginValidator(login, password)) {
            return null;
        } else {
            User result = null;
            Factory factory = Factory.getInstance();
            UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
            try {
                Session session = HibernateUtil.openSession();
                Transaction transaction = session.beginTransaction();
                result = userOperationDAO.checkLogin(login, password);
                transaction.commit();
            } catch (HibernateException e) {
                throw new TransactionException("");
            }
            return result;
        }
    }

    static class Validator {
        public static boolean loginValidator(String login, String password) throws ServiceException {
            if (login.isEmpty() | password.isEmpty()) {
                throw new ServiceException();
            }
            return true;
        }
    }
}
