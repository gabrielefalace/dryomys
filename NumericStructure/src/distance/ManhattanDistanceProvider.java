package distance;

import java.math.BigDecimal;
import java.util.Iterator;

import tuples.Tuple;
import exceptions.ExceptionFactory;
import exceptions.UnsupportedTypeException;

/**
 * This class provides an implementation of the Manhattan distance (also known as block distance)
 * 
 * @author gabriele
 *
 */
public class ManhattanDistanceProvider implements TupleDistanceProvider {

	/**
	 * The Manhattan distance between the two Tuple
	 */
	@Override
	public final strictfp Number distance(Tuple t1, Tuple t2) throws UnsupportedTypeException{
		Number result;
		
		Number n1 = t1.get(0);
		Number n2 = t2.get(0);
		Iterator<Number> i1 = t1.iterator(), i2 = t2.iterator();
		
		if((n1 instanceof Float) && (n2 instanceof Float)){
			result = 0f;
			while(i1.hasNext()){
				float f1 = i1.next().floatValue();
				float f2 = i2.next().floatValue();
				float difference = Math.abs(f1 - f2);
				result = result.floatValue() + difference;
			}
		}
		else if((n1 instanceof Double) && (n2 instanceof Double)){
			result = 0d;
			while(i1.hasNext()){
				double f1 = i1.next().doubleValue();
				double f2 = i2.next().doubleValue();
				double difference = Math.abs(f1 - f2);
				result = result.doubleValue() + difference;
			}
		}
		else if((n1 instanceof BigDecimal) && (n2 instanceof BigDecimal)){
			result = new BigDecimal("0");
			BigDecimal tmp = BigDecimal.ZERO;
			while(i1.hasNext()){
				BigDecimal bd1 = (BigDecimal) i1.next();
				BigDecimal bd2 = (BigDecimal) i2.next();
				BigDecimal difference = bd1.subtract(bd2);
				tmp = tmp.add(difference);
			}
			result = tmp;
		}
		else
			throw ExceptionFactory.createUnsupportedNumberType(n1, n2);
			
		if(result == null){
			throw new NullPointerException("The distance method from DefaultDistanceProvider computed a null distance");
		}
		else{		
			return result;
		}
	}
	
	
}
