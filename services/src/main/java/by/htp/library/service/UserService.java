package by.htp.library.service;

import by.htp.library.dao.Factory;
import by.htp.library.dao.SQLCommandDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;
import by.htp.library.service.exception.ServiceException;

public final class UserService {
	public final static User checkLogin(String login, String password) throws ServiceException, DAOException {
		if (!Validator.loginValidator(login, password)) {
			return null;
		} else {
			Factory factory = Factory.getInstance();
			SQLCommandDAO sqlCommandDAO = factory.getSqlCommandDAO();
			return sqlCommandDAO.checkLogin(login, password);
		}
	}



	static class Validator {
		public static boolean loginValidator(String login, String password) throws ServiceException {

			if (login.isEmpty() | password.isEmpty() ) {
				throw new ServiceException();
			}
			return true;
		}
	}
}
