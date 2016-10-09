package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * Created by oxothuk1401 on 06.10.2016.
 */
public abstract class OperationDAO<T> {
    Session session = HibernateUtil.openSession();
    Transaction transaction = null;
    //добавление
    public T add(T t) {
        transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        if (transaction != null) {
            transaction.rollback();
            session.close();
        }
        return t;
    }
    //удаление
    public T delete(T t) {
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        if (transaction != null) {
            transaction.rollback();
            session.close();
        }
        return t;
    }
    //обновление
 public T update(T t) {
        session.beginTransaction();
        session.merge(t);
        session.getTransaction().commit();
        if (transaction != null) {
            transaction.rollback();
            session.close();
        }
        return t;
    }
    //посик по id
    public T get(long id) {
        T t = null;
        t = (T) session.find(getPersistentClass(), id);
        if (session.isOpen()) {
            session.close();
        }
        return t;
    }

    //показать все
    public List<T> getAll() throws DAOException {
        List<T> t = null;
        t = session.createCriteria(getPersistentClass()).list();
        if (session.isOpen()) {
            session.close();
        }
        return t;
    }

    public abstract Class getPersistentClass();

}
