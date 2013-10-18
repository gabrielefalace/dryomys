package distance;

import java.math.BigDecimal;

import exceptions.ExceptionFactory;
import exceptions.UnsupportedNumberTypeException;

public class DefaultDistanceProvider implements NumericDistanceProvider {

	
	@Override
	public final Number distance(Number n1, Number n2) throws UnsupportedNumberTypeException{
		Number result;
		
		if((n1 instanceof Float) && (n2 instanceof Float)){
			float f1 = n1.floatValue();
			float f2 = n2.floatValue();
			float difference = Math.abs(f1 - f2);
			result = new Float(difference);
		}
		else if((n1 instanceof Double) && (n2 instanceof Double)){
			double d1 = (Double)n1;
			double d2 = (Double)n2;
			double difference = Math.abs(d1 - d2);
			result = new Double(difference);
		}
		else if((n1 instanceof BigDecimal) && (n2 instanceof BigDecimal)){
			BigDecimal bd1 = (BigDecimal)n1;
			BigDecimal bd2 = (BigDecimal)n2;
			BigDecimal difference = bd1.subtract(bd2);
			result = difference.abs();
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
