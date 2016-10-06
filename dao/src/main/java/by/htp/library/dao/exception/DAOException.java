package by.htp.library.dao.exception;

public class DAOException extends Exception {
	private static final long serialVersionUID = 8845789250769416516L;

	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}

    public DAOException() {

    }
}
