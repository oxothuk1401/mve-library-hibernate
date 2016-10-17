package by.htp.library.service;

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

public final class UserServiceOperation {
    private static Logger log = Logger.getLogger(UserServiceOperation.class.getName());

    public final static User userOperation(String user,String command) throws DAOException, ServiceException {
        if (!Validator.userValidator(user)) {
            return null;
        } else {
            User result = null;
            Factory factory = Factory.getInstance();
            UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
            Session session = HibernateUtil.getSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                switch (command){
                    case "delete-user": result = userOperationDAO.deleteUser(user);break;
                    case "block-user": result = userOperationDAO.blockUser(user);break;
                    case "unlock-user": result = userOperationDAO.unLockUser(user);break;
                }
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
        public static boolean userValidator(String user) throws ServiceException {
            if (user.isEmpty()) {
                throw new ServiceException();
            }
            return true;
        }
    }
}


//
//package by.htp.library.service;
//
//        import by.htp.library.dao.Factory;
//        import by.htp.library.dao.HibernateUtil;
//        import by.htp.library.dao.UserOperationDAO;
//        import by.htp.library.dao.exception.DAOException;
//        import by.htp.library.entity.User;
//        import by.htp.library.service.exception.ServiceException;
//        import org.apache.log4j.Logger;
//        import org.hibernate.HibernateException;
//        import org.hibernate.Session;
//        import org.hibernate.Transaction;
//        import org.hibernate.TransactionException;
//
//public final class DeleteUserService {
//    private static Logger log = Logger.getLogger(DeleteUserService.class.getName());
//
//    public final static User deliteUser(String user) throws DAOException, ServiceException {
//        if (!DeleteUserService.Validator.userValidator(user)) {
//            return null;
//        } else {
//            User result = null;
//            Factory factory = Factory.getInstance();
//            UserOperationDAO userOperationDAO = factory.getUserOperationDAO();
//            Session session = HibernateUtil.getSession();
//            Transaction transaction = null;
//            try {
//                transaction = session.beginTransaction();
//                result = userOperationDAO.deleteUser(user);
//                transaction.commit();
//            } catch (HibernateException e) {
//                if (transaction != null) {
//                    transaction.rollback();
//                }
//                throw new TransactionException("");
//            }
//            return result;
//        }
//    }
//
//    static class Validator {
//        public static boolean userValidator(String user) throws ServiceException {
//            if (user.isEmpty()) {
//                throw new ServiceException();
//            }
//            return true;
//        }
//    }
//}
