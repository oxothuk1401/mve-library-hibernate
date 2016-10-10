package by.htp.library.service;

import by.htp.library.dao.Factory;
import by.htp.library.dao.HibernateUtil;
import by.htp.library.dao.UserOperationDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.service.exception.ServiceException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;


public class RegisterService {

	public final static boolean checkRegister(String login, String password) throws ServiceException, DAOException, TransactionException {
		if (!Validator.registerValidator(login, password)) {
			return false;
		} else {
			boolean result = false;
			Factory factory = Factory.getInstance();
            UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
			try{
				Session session = HibernateUtil.openSession();
				Transaction transaction = session.beginTransaction();
				result = userOperationDAO.checkRegister(login,password);
				transaction.commit();
			}catch (HibernateException e) {
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