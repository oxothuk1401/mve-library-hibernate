package by.htp.library.service;

import by.htp.library.dao.DBUserOperationDAO;
import by.htp.library.dao.Factory;
import by.htp.library.dao.HibernateUtil;
import by.htp.library.dao.UserOperationDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import by.htp.library.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;


public class RegisterService {
	private static Logger log = Logger.getLogger(DBUserOperationDAO.class.getName());

	public final static User checkRegister(String login, String password) throws ServiceException, DAOException {
		if (!Validator.registerValidator(login, password)) {
			return null;
		} else {
			User result = null;
            Factory factory = Factory.getInstance();
            UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
            Session session = HibernateUtil.getSession();
			log.info("session_checkRegister_service = " + session.hashCode());
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                result = userOperationDAO.checkRegister(login, password);
				log.info("session_checkRegister_service_return = " + session.hashCode());
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