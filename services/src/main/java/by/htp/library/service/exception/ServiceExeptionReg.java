package by.htp.library.service.exception;

public class ServiceExeptionReg extends Exception {
	private static final long serialVersionUID = 1L;
	public ServiceExeptionReg(String message){
		super(message);
	}
	public ServiceExeptionReg(String message, Exception e){
		super(message, e);
	}
}
