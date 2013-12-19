package org.dryomys.distance;

import java.math.BigDecimal;

import org.dryomys.exceptions.ExceptionFactory;
import org.dryomys.exceptions.UnsupportedTypeException;

import static org.dryomys.util.NumericUtils.*;

/**
 * This class simply provides an implementation of the distance between two Numbers as the absolute value of their difference.
 * 
 * @author gabriele
 *
 */
public class DefaultDistanceProvider implements DistanceProvider<Number> {

	/**
	 * The distance as a simple difference, in absolute value
	 */
	@Override
	public final Number distance(Number n1, Number n2) throws UnsupportedTypeException{
		Number result = null;
		BigDecimal bd1, bd2;
		
		
		if((n1 instanceof BigDecimal) && (n2 instanceof BigDecimal)){
			bd1 = (BigDecimal)n1;
			bd2 = (BigDecimal)n2;
			BigDecimal difference = bd1.subtract(bd2);
			result = difference.abs();
		}
		else if(isProper(n1) && isProper(n2) && checkSameType(n1, n2)){
			bd1 = new BigDecimal(n1.doubleValue());
			bd2 = new BigDecimal(n2.doubleValue());
		}
		else{
			throw ExceptionFactory.createUnsupportedNumberType(n1, n2);
		}
			
		if(result == null){
			throw new NullPointerException("The distance method from DefaultDistanceProvider computed a null distance");
		}
		else{		
			return result;
		}
	}
	
}
