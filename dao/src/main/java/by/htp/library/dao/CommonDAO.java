package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.Book;
import by.htp.library.entity.User;

import java.util.List;

public interface CommonDAO {

    User checkLogin(String login, String password) throws DAOException;

    boolean checkRegister(String number, String password) throws DAOException;

    boolean deleteUser(String user) throws DAOException;

    List<String> getUsers() throws DAOException;

    List<Book> getBooks() throws DAOException;

    List<Book> checkSearch(String searching) throws DAOException;

}
