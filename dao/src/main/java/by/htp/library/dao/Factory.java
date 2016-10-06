package by.htp.library.dao;

public class Factory {
    private static Factory instance = new Factory();

    private SQLCommandDAO sqlCommandDAO = new SQLCommandDAO();

    private Factory() {
    }

    public static Factory getInstance() {
        return instance;
    }

    public SQLCommandDAO getSqlCommandDAO() {
        return sqlCommandDAO;
    }

}
