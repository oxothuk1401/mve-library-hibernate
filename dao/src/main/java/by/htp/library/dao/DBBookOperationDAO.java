package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;

/**
 * Created by oxothuk1401 on 07.10.2016.
 */
public class DBBookOperationDAO extends OperationDAO implements BookOperationDAO  {
    private static Logger log = Logger.getLogger(DBUserOperationDAO.class.getName());
    Session session = HibernateUtil.getSession();
    @Override
    public List getAll() throws DAOException {

        log.info(session.hashCode());
        try {
            Query query = session.createQuery("from Book");
            List<Book> listBooks = (List<Book>) query.list();
            if (listBooks == null) {
                    throw new DAOException("List of books is empty");
                }
            return listBooks;
        }catch (Exception e) {
                throw new DAOException("Error accessing database");
            }
    }

//        @Override
//    public List<Book> checkSearch(String searching) throws DAOException {
//
//        return null;
//    }



    @Override
    public Class getPersistentClass() {
        return Book.class;
    }
}
