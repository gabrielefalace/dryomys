package distance;

import exceptions.UnsupportedTypeException;

/**
 * This interface defines the DistanceProvider to make calculations among Number objects
 * 
 * @author gabriele
 *
 */
public interface NumericDistanceProvider extends DistanceProvider<Number> {
	
	/**
	 * Computes the distance between two given numbers (Number)
	 * @param n1 the first Number
	 * @param n2 the second Number
	 * @return the distance between the two Number
	 * @throws UnsupportedTypeException if one of the two arguments is different from Float/Double/BigDecimal
	 */
	public Number distance(Number n1, Number n2) throws UnsupportedTypeException;

}
