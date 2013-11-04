package numeric_core;

import org.eclipse.jdt.annotation.Nullable;

import tuples.Tuple;
import util.NumericUtils;
import distance.DefaultDistanceProvider;
import distance.DistanceProvider;
import exceptions.UnsupportedTypeException;



public class NumericEngine {

	private DistanceProvider<Number> distanceProvider;
	
	
	public NumericEngine(){
		distanceProvider = new DefaultDistanceProvider();
		/*
		 * TODO default constructor
		 */
	}
	
	
	
	public NumericEngine(DistanceProvider<Number> aProvider){
		distanceProvider = aProvider;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public DistanceProvider<Number> getDistanceProvider() {
		return distanceProvider;
	}


	/**
	 * 
	 * @param distanceProvider
	 */
	public void setDistanceProvider(DistanceProvider<Number> distanceProvider) {
		this.distanceProvider = distanceProvider;
	}
	
	
	/**
	 * Finds the Number in the array which is closer to another given Number, according to the DistanceProvider used.
	 * @param number the number to be found
	 * @param array the array of Number to search in
	 * @return the Number in the array which has the minimum distance to the given number
	 * @throws UnsupportedTypeException if Number used are not Float, Double or BigDecimal
	 */
	public final @Nullable Number getClosest(Number number, Number[] array) throws UnsupportedTypeException {
		if(array.length==0){
			throw new NullPointerException("method \"getClosest\" called on an empty structure");
		}
		else{
			Number currentBest = array[0];
			Number currentDist;
			if(currentBest == null){
				throw new NullPointerException("A null element was found in the collection!");
			}
			else{
				currentDist = distanceProvider.distance(currentBest, number);
				
				for(Number elem: array){
					if(elem == null){
						throw new NullPointerException("A null element was found in the collection!");
					}
					else{
						Number tmpDist = distanceProvider.distance(elem, number);
						if(tmpDist != null && currentDist != null && NumericUtils.lessThan(tmpDist, currentDist, NumericUtils.STRICT)){
							currentBest = elem;
							currentDist = tmpDist;
						}
					}
				}
			}

			return currentBest;
		}
	}
	
	
	
	/**
	 * Checks if two given Number are approximately equal, according to a given level of approximation, delta. 
	 * Formally using the distance function n1 and n2 are approximatelyEqual if distance(n1,n2) <= delta.
	 * @param n1 a Number 
	 * @param n2 another Number
	 * @param delta the tolerance for equality
	 * @return true if the number are approximately equal
	 * @throws UnsupportedTypeException when one of the arguments is not Float, Double or BigDecimal.
	 */
	public final boolean approximatelyEqual(Number n1, Number n2, Number delta) throws UnsupportedTypeException {
		Number distance = distanceProvider.distance(n1, n2);
		boolean result = false;
		if(distance != null){
			result = NumericUtils.lessThan(distance, delta, false);
		}
		
		return result;
	}

	
}
