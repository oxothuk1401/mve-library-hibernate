//package by.htp.library.dao;
//
//import by.htp.library.dao.connectionpool.ConnectionPool;
//import by.htp.library.dao.connectionpool.exception.ConnectionPoolException;
//import by.htp.library.dao.exception.DAOException;
//import by.htp.library.entity.Book;
//import by.htp.library.entity.User;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SQLCommandDAO implements CommonDAO {
//    private final static String CHECK_LOGIN = "SELECT * FROM Users";
//    private final static String CHECK_REGISTER = "insert into users(login, password, Role, blacklist) values(?,?,?,?)";
//    private final static String DELETE_USER = "DELETE FROM users WHERE login=";
//    private final static String GET_USERS = "SELECT login FROM Users";
//    private final static String GET_BOOKS = "SELECT access, author, title, date, location FROM books";
//    private final static String CHECK_SEARCH = "SELECT * FROM books";
//    ConnectionPool connectionPool = ConnectionPool.getInstance();
//    Connection connection = null;
//    PreparedStatement preparedStatement = null;
//    ResultSet resultSet = null;
//
//    @Override
//    public User checkLogin(String login, String password) throws DAOException {
//        User user = null;
//        try {
//            connection = connectionPool.takeConnection();
//            try {
//                preparedStatement = connection.prepareStatement(CHECK_LOGIN);
//                resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
////                    if (login.equals(resultSet.getString(2)) && password.equals(resultSet.getString(3))) {
//                    if (login.equals(resultSet.getString(2)) && MD5.getMD5(password).equals(resultSet.getString(3))) {
//                        user = new User();
//                        user.setId(resultSet.getInt(1));
//                        user.setLogin(resultSet.getString(2));
//                        user.setPassword(resultSet.getString(3));
//                        user.setRole(resultSet.getString(4));
//                        break;
//                    }
//                }
    //                if (user == null) {
    //                    throw new DAOException();
    //                }
//                connection.close();
//            } catch (SQLException e) {
//                throw new DAOException("Error accessing database");
//            }
//        } catch (ConnectionPoolException e) {
//            throw new DAOException("Has reached the maximum number of connections", e);
//        }
//
//        return user;
//    }
//
//    @Override
//    public boolean checkRegister(String login, String password) throws DAOException {
//        try {
//            connection = connectionPool.takeConnection();
//            try {
//                preparedStatement = connection.prepareStatement(CHECK_REGISTER);
//                preparedStatement.setString(1, login);
//                preparedStatement.setString(2, MD5.getMD5(password));
////                preparedStatement.setString(2, password);
//                preparedStatement.setString(3, "user");
//                preparedStatement.setString(4, "unblock");
//                preparedStatement.executeUpdate();
//                connection.close();
//            } catch (SQLException e) {
//                throw new DAOException();
//            }
//        } catch (ConnectionPoolException e) {
//            throw new DAOException("Has reached the maximum number of connections", e);
//        }
//        return true;
//    }
//
//    @Override
//    public boolean deleteUser(String user) throws DAOException {
//        StringBuilder sb = new StringBuilder();
//        String sql = null;
//        try {
//            connection = connectionPool.takeConnection();
//            try {
//                sb.append(DELETE_USER);
//                sb.append("'");
//                sb.append(user);
//                sb.append("'");
//                sql = sb.toString();
//                preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.executeUpdate();
//                connection.close();
//            } catch (SQLException e) {
//                throw new DAOException("Error accessing database");
//            }
//        } catch (ConnectionPoolException e) {
//            throw new DAOException("Has reached the maximum number of connections", e);
//        }
//        return true;
//    }
//
//    @Override
//    public List<String> getUsers() throws DAOException {
//        List<String> listUsers = new ArrayList<>();
//        try {
//            connection = connectionPool.takeConnection();
//            try {
//                preparedStatement = connection.prepareStatement(GET_USERS);
//                resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    listUsers.add(resultSet.getString(1));
//
//                }
//                connection.close();
//            } catch (SQLException e) {
//                throw new DAOException("Error accessing database");
//            }
//
//        } catch (ConnectionPoolException e) {
//            throw new DAOException("Has reached the maximum number of connections", e);
//
//        }
//        return listUsers;
//    }
//
//    @Override
//    public List<Book> getBooks() throws DAOException {
//        List<Book> listBooks = new ArrayList<>();
//        try {
//            connection = connectionPool.takeConnection();
//            try {
//                preparedStatement = connection.prepareStatement(GET_BOOKS);
//                resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    Book book = new Book();
//                    book.setAccess(resultSet.getNString(1));
//                    book.setTitle(resultSet.getNString(3));
//                    book.setDate(resultSet.getNString(4));
//                    book.setLocation(resultSet.getNString(5));
//                    listBooks.add(book);
//                }
//                connection.close();
//            } catch (SQLException e) {
//                throw new DAOException("Error accessing database");
//            }
//        } catch (ConnectionPoolException e) {
//            throw new DAOException("Has reached the maximum number of connections", e);
//        }
//        return listBooks;
//    }
//
//    @Override
//    public List<Book> checkSearch(String searching) throws DAOException {
//        List<Book> listBooks = new ArrayList<>();
//        String str = null;
//        try {
//            connection = connectionPool.takeConnection();
//            try {
//                preparedStatement = connection.prepareStatement(CHECK_SEARCH);
//                resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    str = resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5);
//                    if (str.toLowerCase().contains(searching.toLowerCase())) {
//                        listBooks.add(new Book(resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
//                    }
//                }
//                connection.close();
//                if (listBooks.isEmpty()) {
//                    throw new DAOException();
//                }
//            } catch (SQLException e) {
//                throw new DAOException("Error accessing database");
//            }
//        } catch (ConnectionPoolException e) {
//            throw new DAOException("Has reached the maximum number of connections", e);
//        }
//        return listBooks;
//    }
//
//}
