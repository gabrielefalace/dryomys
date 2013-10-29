package exceptions;

/**
 * This Exception reports that there's been an attempt to use an object of type different from Float/Double/BigDecimal.
 * Types different from those listed above (and related auto-boxable primitives) are not allowed in the system.
 * 
 * @author gabriele
 *
 */
public class UnsupportedNumberTypeException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * default constructor
	 */
	public UnsupportedNumberTypeException() {
		super();
	}
	
	/**
	 * Single string constructor
	 * @param s the string passed to superclass.
	 */
	public UnsupportedNumberTypeException(String s) {
		super(s);
	}
	
	/**
	 * A more detailed constructor, reporting information about the object violating allowed types.
	 * @param object the not allowed object.
	 */
	public UnsupportedNumberTypeException(Object object) {
		super("ATTENTION! ONLY SUPPORTED TYPES ARE: Float, Double, BigDecimal \n You used a "+object.getClass().getName());
	}
	
}
