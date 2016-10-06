//package by.htp.library.service;
//
//import by.htp.library.dao.Factory;
//import by.htp.library.dao.SQLCommandDAO;
//import by.htp.library.dao.exception.DAOException;
//
//import java.util.List;
//
//public final class ShowUsersService {
//
//	public final static List<String> showUsers(String showusers) throws DAOException {
//		Factory factory = Factory.getInstance();
//		SQLCommandDAO sqlCommandDAO = factory.getSqlCommandDAO();
//		return sqlCommandDAO.getUsers();
//	}
//
//
//}
