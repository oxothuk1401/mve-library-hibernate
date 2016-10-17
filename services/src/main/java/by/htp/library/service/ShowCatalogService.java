package by.htp.library.service;

import by.htp.library.dao.BookOperationDAO;
import by.htp.library.dao.Factory;
import by.htp.library.dao.HibernateUtil;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import java.util.List;

public final class ShowCatalogService {
    private static Logger log = Logger.getLogger(ShowCatalogService.class.getName());

    public final static List<Book> showBooks() throws DAOException {
        List result = null;
        Factory factory = Factory.getInstance();
        BookOperationDAO bookOperationDAO = factory.getBookOperationDAO();
        Session session = HibernateUtil.getSession();
        log.info("session_showBooks_service = " + session.hashCode());
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = bookOperationDAO.getAll();
            log.info("session_showBooks_service_return = " + session.hashCode());
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
