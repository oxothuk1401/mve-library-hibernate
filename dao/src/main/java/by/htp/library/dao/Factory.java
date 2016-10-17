package by.htp.library.dao;

public class Factory {
    private static final Factory instance = new Factory();

    private BookOperationDAO bookOperationDAO = new DBBookOperationDAO();
    private UserOperationDAO userOperationDAO = new DBUserOperationDAO();

    private Factory() {
    }

    public static Factory getInstance() {
        return instance;
    }

    public BookOperationDAO getBookOperationDAO() { return bookOperationDAO; }
    public UserOperationDAO getUserOperationDAO() { return userOperationDAO; }
}
