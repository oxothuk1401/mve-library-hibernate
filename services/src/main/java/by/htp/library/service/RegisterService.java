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


public class RegisterService {

	public final static User checkRegister(String login, String password) throws ServiceException, DAOException {
		if (!Validator.registerValidator(login, password)) {
			return null;
		} else {
			User result = null;
            Factory factory = Factory.getInstance();
            UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
            Session session = HibernateUtil.getSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                result = userOperationDAO.checkRegister(login, password);
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

	static class Validator {
		public static boolean registerValidator(String login, String password) throws ServiceException {
			if (login.isEmpty() | password.isEmpty()) {
				throw new ServiceException();
			}
			return true;
		}
	}
}