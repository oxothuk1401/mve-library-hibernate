package by.htp.library.service;

import by.htp.library.dao.Factory;
import by.htp.library.dao.UserOperationDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;

import java.util.List;

public final class ShowUsersService {

	public final static List<User> showUsers() throws DAOException {
		Factory factory = Factory.getInstance();
		UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
		return userOperationDAO.getAll();
	}


}
