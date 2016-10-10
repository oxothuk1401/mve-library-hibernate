package by.htp.library.service;

import by.htp.library.dao.Factory;
import by.htp.library.dao.UserOperationDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.service.exception.ServiceException;

public class DeleteUserService {
    public final static boolean deliteUser(String user) throws DAOException, ServiceException {
        if (!DeleteUserService.Validator.userValidator(user)) {
            return false;
        } else {
            Factory factory = Factory.getInstance();
            UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
            return userOperationDAO.deleteUser(null);
        }
    }

    static class Validator {
        public static boolean userValidator(String user) throws ServiceException {
            if (user.isEmpty()) {
                throw new ServiceException();
            }
            return true;
        }
    }
}
