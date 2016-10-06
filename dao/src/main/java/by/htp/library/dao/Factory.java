package by.htp.library.dao;

public class Factory {
    private static final Factory instance = new Factory();

    private BookOperationDAO bookOperationDAO;
    private UserOperationDAO userOperationDAO = new DBUserOperationDAO();
    private AuthorOperationDAO authorOperationDAO = new DBAuthorOperationDAO();

    private Factory() {
    }

    public static Factory getInstance() {
        return instance;
    }

    public BookOperationDAO getBookOperationDAO() {
        if(bookOperationDAO == null){
            bookOperationDAO= new DBBookOperationDAO();
        }
        return bookOperationDAO;
    }

    public UserOperationDAO getUserOperationDAO() {
        return userOperationDAO;
    }

    public AuthorOperationDAO getAuthorOperationDAO() {
        return authorOperationDAO;
    }
}
