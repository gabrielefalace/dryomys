package exceptions;

import util.NumericUtils;

/**
 * 
 * @author Gabriele Falace
 * 
 */
public class ExceptionFactory {

	
	private static NumericUtils numericUtils;
	
	
	static {
		numericUtils = NumericUtils.getInstance();
	}
	
	
	/**
	 * Creates an UnsupportedNumberTypeException based on the first object that is of an unsupported type, given an array of objects.
	 * @param numbers an array of Number in which at least one is not of a supported type
	 * @return an UnsupportedNumberTypeException referring to the first object of an unsupported type
	 */
	public static final UnsupportedNumberTypeException createUnsupportedNumberType(Number ... numbers){
		UnsupportedNumberTypeException unte = null;
		for(Number o: numbers){
			if(o != null && !numericUtils.isProper(o)){
				unte = new UnsupportedNumberTypeException(o);
				break;
			}
		}
		if(unte == null){
			unte = new UnsupportedNumberTypeException("Unsupported type, not related to a particular number");
		}
		return unte;
	}
	
	
}
