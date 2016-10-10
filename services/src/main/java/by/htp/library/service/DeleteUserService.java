package by.htp.library.service;

import by.htp.library.dao.Factory;
import by.htp.library.dao.UserOperationDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;

public class DeleteUserService {
	public final static String deliteUser(String user) throws DAOException {
        Factory factory = Factory.getInstance();
        UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
        return userOperationDAO.delete(user);
    }
}
