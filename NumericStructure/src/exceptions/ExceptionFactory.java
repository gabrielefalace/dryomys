package exceptions;

import util.NumericUtils;

/**
 * 
 * @author Gabriele Falace
 * 
 */
public class ExceptionFactory {

	
	
	
	/**
	 * Creates an UnsupportedNumberTypeException based on the first object that is of an unsupported type, given an array of objects.
	 * @param numbers an array of Number in which at least one is not of a supported type
	 * @return an UnsupportedNumberTypeException referring to the first object of an unsupported type
	 */
	public static final UnsupportedTypeException createUnsupportedNumberType(Number ... numbers){
		UnsupportedTypeException unte = new UnsupportedTypeException("Unsupported type, not related to a particular number");
		for(Number o: numbers){
			if(o != null && !NumericUtils.isProper(o)){
				unte = new UnsupportedTypeException(o);
				break;
			}
		}
		return unte;
	}
	
	
}
