package exceptions;

public class UnsupportedNumberTypeException extends Exception {

	private static final long serialVersionUID = 1L;

	
	public UnsupportedNumberTypeException() {
		super();
	}
	
	public UnsupportedNumberTypeException(String s) {
		super(s);
	}
	
	public UnsupportedNumberTypeException(Object object) {
		super("ATTENTION! ONLY SUPPORTED TYPES ARE: Float, Double, BigDecimal \n You used a "+object.getClass().getName());
	}
	
}
