package org.dryomys.util;

import org.dryomys.tuples.Tuple;


/**
 * 
 * @author gabriele
 *
 */
public class TupleUtils {

	/**
	 * 
	 * @param number
	 * @param array
	 * @return true if the Tuple is exactly in the given array
	 */
	public static boolean isExactlyIn(Tuple number, Tuple[] array) {
		boolean result = false;
		for(Tuple current: array){
			if(number.equals(current)){
				result = true;
				break;
			}
		}
		return result;
	}
	
	
	/**
	 * 
	 * @param tuple
	 * @return true if every Number in the Tuple is Float, Double or BigDecimal and all the elements are of the same class.
	 */
	public static boolean isProper(Tuple tuple){
		boolean result = false;
		if(tuple.isEmpty()){
			result = true;
		}
		else{
			Number first = tuple.get(0);
			if(first != null){
				result = true;
				String className = first.getClass().getName();
				for(Number number: tuple){
					if(!className.equals(number.getClass().getName()) || !NumericUtils.isProper(number)){
						result = false;
						break;
					}
				}
			}
		}
		return result;
	}
	
}
