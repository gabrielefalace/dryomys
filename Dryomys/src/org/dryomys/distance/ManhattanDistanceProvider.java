package org.dryomys.distance;

import java.math.BigDecimal;
import java.util.Iterator;

import org.dryomys.exceptions.ExceptionFactory;
import org.dryomys.exceptions.Messages;
import org.dryomys.exceptions.UnsupportedTypeException;
import org.dryomys.tuples.Tuple;

/**
 * This class provides an implementation of the Manhattan distance (also known as block distance)
 * 
 * @author gabriele
 *
 */
public class ManhattanDistanceProvider implements DistanceProvider<Tuple> {

	/**
	 * The Manhattan distance between the two Tuple
	 */
	@Override
	public final strictfp Number distance(Tuple t1, Tuple t2) throws UnsupportedTypeException{
		Number result = new BigDecimal("0");
		
		Number n1 = t1.get(0);
		Number n2 = t2.get(0);
		
		if(n1==null || n2==null){
			throw ExceptionFactory.createUnsupportedNumberType(n1, n2);
		}
		
		Iterator<Number> i1 = t1.iterator(), i2 = t2.iterator();
		if(i1==null){
			throw new NullPointerException(Messages.NULL_RECEIVED + "(while trying to obtain an iterator on tuple " + t1 + ")");
		}
		if(i2==null){
			throw new NullPointerException(Messages.NULL_RECEIVED + "(while trying to obtain an iterator on tuple " + t2 + ")");
		}
			
		BigDecimal bd1, bd2, tmp = BigDecimal.ZERO;
		while(i1.hasNext()){
			if(!(n1 instanceof BigDecimal)){
				bd1 = new BigDecimal(n1.doubleValue());
			}
			else{
				bd1 = (BigDecimal) i1.next();
			}
			if(!(n2 instanceof BigDecimal)){
				bd2 = new BigDecimal(n2.doubleValue());
			}
			else{
				bd2 = (BigDecimal) i2.next();
			}
			
			BigDecimal difference = (bd1.subtract(bd2)).abs();
			tmp = tmp.add(difference);
		}
		result = tmp;
			
		if(result == null){
			throw new NullPointerException("The distance method from DefaultDistanceProvider computed a null distance");
		}
		else{		
			return result;
		}
	}
	
	
}
