package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by oxothuk1401 on 06.10.2016.
 */
public abstract class OperationDAO<T> {
    Session session = HibernateUtil.getSession();
    //добавление
    public T add(T t) {
        Session session = HibernateUtil.getSession();
        session.saveOrUpdate(t);
        return t;
    }

    //удаление
    public T delete(T t) throws DAOException {
        session.delete(t);
        return t;
    }

    //обновление
    public T update(T t) {
        session.update(t);
        return t;
    }

    //посик по id
    public T get(long id) {
        T t = null;
        t = (T) session.find(getPersistentClass(), id);
        return t;
    }

    //показать все
    public List<T> getAll() throws DAOException {
        List<T> t = null;
        t = session.createCriteria(getPersistentClass()).list();
        return t;
    }

    public abstract Class getPersistentClass();

}
