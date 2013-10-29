package exceptions;

import util.NumericUtils;

/**
 * 
 * @author Gabriele Falace
 * 
 */
public class ExceptionFactory {

	/**
	 * reference to the numericUtils
	 */
	private static NumericUtils numericUtils;
	
	
	/**
	 * initializing the static reference to numericUtils
	 */
	static {
		numericUtils = NumericUtils.getInstance();
	}
	
	
	/**
	 * Creates an UnsupportedNumberTypeException based on the first object that is of an unsupported type, given an array of objects.
	 * @param numbers an array of Number in which at least one is not of a supported type
	 * @return an UnsupportedNumberTypeException referring to the first object of an unsupported type
	 */
	public static final UnsupportedNumberTypeException createUnsupportedNumberType(Number ... numbers){
		UnsupportedNumberTypeException unte = new UnsupportedNumberTypeException("Unsupported type, not related to a particular number");
		for(Number o: numbers){
			if(o != null && !numericUtils.isProper(o)){
				unte = new UnsupportedNumberTypeException(o);
				break;
			}
		}
		return unte;
	}
	
	
}
