package util;


import java.math.BigDecimal;

import org.eclipse.jdt.annotation.Nullable;

import distance.DefaultDistanceProvider;
import distance.NumericDistanceProvider;
import exceptions.ExceptionFactory;
import exceptions.UnsupportedNumberTypeException;

/**
 * 
 * @author Gabriele Falace
 * 
 *
 */
public final class NumericUtils implements Utils<Number> {
	
	
	/**
	 * this value means that a comparison operator has to be intended as strict (i.e. < and >)
	 */
	public static final boolean STRICT = true;
	
	
	/**
	 * this value means that a comparison operator has to be intended as strict (i.e. <= and >=)
	 */
	public static final boolean NON_STRICT = false;
	
	
	/**
	 * this variable holds an object that must provide the distance method used for all calculations
	 */
	private static NumericDistanceProvider distanceProvider = new DefaultDistanceProvider();
	
	
	/**
	 * singleton instance returned by the getInstance static method
	 */
	private static NumericUtils numericUtils = new NumericUtils(distanceProvider);
	
	
	
	/**
	 * Private constructor, only used internally to create the unique instance.
	 * @param aDistanceProvider the DistanceProvider, providing the distance method to be used in all operations.
	 */
	private NumericUtils(NumericDistanceProvider aDistanceProvider){
		distanceProvider = aDistanceProvider;
	}
	
	/**
	 * Singleton getInstance method. Only at first invocation, being the variable null, it gets initialized.
	 * In any other case it only returns a reference to that unique object.
	 * Since this methods has no argument, the default DistanceProvider will be used.
	 * @return the instance of NumericUtils
	 */
	public synchronized static NumericUtils getInstance(){
		return numericUtils;
	}

	
	/**
	 * Accesses the instance of DistanceProvider in use
	 * @return the DistanceProvider used
	 */
	public static final NumericDistanceProvider getDistanceProvider(){
		return distanceProvider;
	}
	
	/**
	 * Sets the DistanceProvider to be used
	 * @param aDistanceProvider the DistanceProvider to be set
	 */
	public static final void setDistanceProvider(NumericDistanceProvider aDistanceProvider){
		distanceProvider = aDistanceProvider;
	}
	
	
	
	
	/**
	 * Finds the Number in the array which is closer to another given Number, according to the DistanceProvider used.
	 * @param number the number to be found
	 * @param array the array of Number to search in
	 * @return the Number in the array which has the minimum distance to the given number
	 * @throws UnsupportedNumberTypeException if Number used are not Float, Double or BigDecimal
	 */
	public final @Nullable Number getClosest(Number number, Number[] array) throws UnsupportedNumberTypeException {
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
						if(tmpDist != null && currentDist != null && lessThan(tmpDist, currentDist, STRICT)){
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
	 * Checks if the passed Number is exactly in this collection, using equals.
	 * This method does not rely on the approximately equals concept
	 * @param number the Number to be found
	 * @param array the array in which the search is to be performed
	 * @return true if the element is found, false otherwise
	 */
	public final boolean isExactlyIn(Number number, Number[] array){
		boolean outcome = false;
		for(Number iter: array){
			if(number.equals(iter)){
				outcome = true;
				break;
			}
		}
		return outcome;
	}
	
	
	/**
	 * Checks if two given Number are approximately equal, according to a given level of approximation, delta. 
	 * Formally using the distance function n1 and n2 are approximatelyEqual if distance(n1,n2) <= delta.
	 * @param n1 a Number 
	 * @param n2 another Number
	 * @param delta the tolerance for equality
	 * @return true if the number are approximately equal
	 * @throws UnsupportedNumberTypeException when one of the arguments is not Float, Double or BigDecimal.
	 */
	public final boolean approximatelyEqual(Number n1, Number n2, Number delta) throws UnsupportedNumberTypeException {
		Number distance = distanceProvider.distance(n1, n2);
		boolean result = false;
		
//		if(isFloat(n1) && isFloat(n2)){
//			float distanceF = distance.floatValue();
//			float deltaF = delta.floatValue();
//			result = distanceF <= deltaF;
//		}
//		else if(isDouble(n1) && isDouble(n2)){
//			double distanceD = distance.doubleValue();
//			double deltaD = delta.doubleValue();
//			result = distanceD <= deltaD;
//		}
//		else if(isBigDecimal(n1) && isBigDecimal(n2)){
//			BigDecimal distanceBD = (BigDecimal) distance;
//			BigDecimal deltaBD = (BigDecimal) delta;
//			result = distanceBD.compareTo(deltaBD) <= 0;
//		}
//		else{
//			throw ExceptionFactory.createUnsupportedNumberType(n1, n2);
//		}
		
		if(distance != null){
			result = this.lessThan(distance, delta, false);
		}
		
		return result;
	}


	/**
	 * Checks if a number is bigger then another.
	 * @param n1 a Number to compare
	 * @param n2 the other Number to compare
	 * @param strictness if set to true, it has a ">" semantic, otherwise it means ">="
	 * @return a boolean given by strictness==true? n1>n2 : n1>=n2
	 * @throws UnsupportedNumberTypeException
	 */
	public final boolean greaterThan(Number n1, Number n2, boolean strictness)throws UnsupportedNumberTypeException {
//		boolean result = false;
//		
//		if((n1 instanceof Float) && (n2 instanceof Float)){
//			float f1 = n1.floatValue();
//			float f2 = n2.floatValue();
//			result = strictness? f1>f2: f1>=f2;
//		}
//		else if((n1 instanceof Double) && (n2 instanceof Double)){
//			double d1 = (Double)n1;
//			double d2 = (Double)n2;
//			result = strictness? d1>d2: d1>=d2;
//		}
//		else if((n1 instanceof BigDecimal) && (n2 instanceof BigDecimal)){
//			BigDecimal bd1 = (BigDecimal)n1;
//			BigDecimal bd2 = (BigDecimal)n2;
//			int comparison = bd1.compareTo(bd2);
//			result = strictness? comparison==1: comparison>=0;
//		}
//		else{
//			throw ExceptionFactory.createUnsupportedNumberType(n1, n2);
//		}
//		return result;
		
		return !lessThan(n1, n2, !strictness);
	}
	
	
	/**
	 * Checks if a number is smaller then another.
	 * @param n1 a Number to compare
	 * @param n2 the other Number to compare
	 * @param strictness if set to true, it has a "<" semantic, otherwise it means "<="
	 * @return a boolean given by strictness==true? n1<n2 : n1<=n2
	 * @throws UnsupportedNumberTypeException
	 */
	public final boolean lessThan(Number n1, Number n2, boolean strictness)throws UnsupportedNumberTypeException {
		boolean result = false;
		
		if((n1 instanceof Float) && (n2 instanceof Float)){
			float f1 = n1.floatValue();
			float f2 = n2.floatValue();
			result = strictness? f1<f2: f1<=f2;
		}
		else if((n1 instanceof Double) && (n2 instanceof Double)){
			double d1 = (Double)n1;
			double d2 = (Double)n2;
			result = strictness? d1<d2: d1<=d2;
		}
		else if((n1 instanceof BigDecimal) && (n2 instanceof BigDecimal)){
			BigDecimal bd1 = (BigDecimal)n1;
			BigDecimal bd2 = (BigDecimal)n2;
			int comparison = bd1.compareTo(bd2);
			result = strictness? comparison==-1: comparison<=0;
		}
		else{
			throw ExceptionFactory.createUnsupportedNumberType(n1, n2);
		}
		return result;
	}
	

	/**
	 * Checks if two given Number are actually instances of the same class. 
	 * @param n1 the first Number to be compared
	 * @param n2 the second Number to be compared
	 * @return true if the two Number are from the same class
	 * @throws UnsupportedNumberTypeException when Number is not Float, Double or BigDecimal
	 */
	public final boolean checkSameType(Number n1, Number n2) throws UnsupportedNumberTypeException {
		if(isProper(n1) && isProper(n2)){
			
			boolean result = false;
			String typeN1 = n1.getClass().getName();
			String typeN2 = n2.getClass().getName();
			
			if(typeN1.equals(typeN2)){
				result = true;
			}
			
			return result;
		}
		else{
			throw ExceptionFactory.createUnsupportedNumberType(n1, n2);
		}
	}
	
	/**
	 * Checks if a given Object is of one of the supported types: Float, Double or BigDecimal
	 * @param object the object to be checked
	 * @return true if the object is one of the supported types
	 */
	public final boolean isProper(Number object){
		return isFloat(object) || isDouble(object) || isBigDecimal(object);
	}
	
	
	/**
	 * Tests if a given Object is a Float
	 * @param object the Object to test
	 * @return true if the argument is a Float
	 */
	public final boolean isFloat(Object object){
		return object instanceof Float;
	}
	
	
	/**
	 * Tests if a given Object is a Double
	 * @param object the Object to test
	 * @return true if the argument is a Double
	 */
	public final boolean isDouble(Object object){
		return object instanceof Double;
	}

	
	/**
	 * Tests if a given Object is a BigDecimal
	 * @param object the Object to test
	 * @return true if the argument is a BigDecimal
	 */
	public final boolean isBigDecimal(Object object){
		return object instanceof BigDecimal;
	}

}
