//package by.htp.library.service;
//
//import by.htp.library.dao.Factory;
//import by.htp.library.dao.SQLCommandDAO;
//import by.htp.library.dao.exception.DAOException;
//import by.htp.library.service.exception.ServiceException;
//public class RegisterService {
//
//	public final static boolean checkRegister(String login, String password) throws ServiceException,DAOException {
//		if (!Validator.registerValidator(login, password)) {
//			return false;
//		} else {
//			Factory factory = Factory.getInstance();
//			SQLCommandDAO sqlCommandDAO = factory.getSqlCommandDAO();
//			return sqlCommandDAO.checkRegister(login, password);
//		}
//	}
//
//	static class Validator {
//
//		public static boolean registerValidator(String login, String password) throws ServiceException {
//			if (login.isEmpty() | password.isEmpty()) {
//				throw new ServiceException();
//			}
//			return true;
//		}
//	}
//}