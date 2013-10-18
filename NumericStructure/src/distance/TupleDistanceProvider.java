package distance;

import tuples.Tuple;
import exceptions.UnsupportedNumberTypeException;

public interface TupleDistanceProvider extends DistanceProvider<Tuple>{
	
	/**
	 * Computes the distance between two given tuples (Tuple objects)
	 * @param t1 the first Tuple
	 * @param t2 the second Tuple
	 * @return the distance between the two Tuple
	 * @throws UnsupportedNumberTypeException if one of the two arguments contains some element of type different from Float, Double or BigDecimal
	 */
	public Number distance(Tuple t1, Tuple t2) throws UnsupportedNumberTypeException;

}
