package distance;

import exceptions.UnsupportedNumberTypeException;

/**
 * 
 * @author Gabriele Falace
 *
 */
public interface NumericDistanceProvider extends DistanceProvider<Number> {
	
	/**
	 * Computes the distance between two given numbers (Number)
	 * @param n1 the first Number
	 * @param n2 the second Number
	 * @return the distance between the two Number
	 * @throws UnsupportedNumberTypeException if one of the two arguments is different from Float, Double or BigDecimal
	 */
	public Number distance(Number n1, Number n2) throws UnsupportedNumberTypeException;

}