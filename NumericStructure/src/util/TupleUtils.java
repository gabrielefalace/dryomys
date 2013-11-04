package util;

import org.eclipse.jdt.annotation.Nullable;
import tuples.Tuple;
import distance.ManhattanDistanceProvider;
import exceptions.UnsupportedTypeException;


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
	 * @return
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
	 * @return
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
					if(!className.equals(number.getClass().getName())){
						result = false;
						break;
					}
				}
			}
		}
		return result;
	}
	
}
