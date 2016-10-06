//package by.htp.library.service;
//
//import by.htp.library.dao.Factory;
//import by.htp.library.dao.SQLCommandDAO;
//import by.htp.library.dao.exception.DAOException;
//import by.htp.library.entity.Book;
//import by.htp.library.service.exception.ServiceException;
//
//import java.util.List;
//
//public class SearchService {
//
//	public final static List<Book> checkSearch(String searching) throws ServiceException, DAOException {
//		if (!Validator.searchValidator(searching)) {
//			return null;
//		} else {
//			Factory factory = Factory.getInstance();
//			SQLCommandDAO sqlCommandDAO = factory.getSqlCommandDAO();
//			return sqlCommandDAO.checkSearch(searching);
//		}
//	}
//
//	static class Validator {
//		public static boolean searchValidator(String searching) throws ServiceException {
//			if (searching.isEmpty()) {
//				throw new ServiceException();
//			}
//			return true;
//		}
//	}
//}