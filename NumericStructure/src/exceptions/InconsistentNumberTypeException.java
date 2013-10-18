package exceptions;

public class InconsistentNumberTypeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	
	public InconsistentNumberTypeException() {
		super();
	}
	
	public InconsistentNumberTypeException(String s) {
		super(s);
	}
	
	
	public InconsistentNumberTypeException(Number actual, Number expected){
		super("Exception: actual type "+actual.getClass().getName()+" while collection expected "+expected.getClass().getName());
	}

}
