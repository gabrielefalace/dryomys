package numeric_core;

import exceptions.ExceptionFactory;
import exceptions.InconsistentNumberTypeException;
import exceptions.UnsupportedTypeException;
import static util.NumericUtils.*;

/**
 * 
 * TODO VERIFY THAT CLASSES EXTENDING THIS DO NOT SUPPORT NULL VALUES!
 * 
 * @author gabriele
 *
 */
public abstract class NumericStructure {

	/**
	 * the delta to be used to compute approximate equalities
	 */
	protected Number delta = new Float(0);
	
	
	/**
	 * a reference to the NumericUtils unique instance
	 */
	protected NumericEngine engine = NumericEngine.getInstance();

	
	/**
	 * Retrieves the current delta value
	 * @return the delta
	 */
	public Number getDelta(){
		return this.delta;
	}
	
	/**
	 * Returns the data type allowed in this structure
	 * @return a String that is the class name of the delta, which constraints the type of data this structure should hold
	 * @throws UnsupportedTypeException
	 */
	public String getStructureType() throws UnsupportedTypeException {
		String result = delta.getClass().getName();
		if(result == null){
			throw ExceptionFactory.createUnsupportedNumberType(delta);
		}
		else{
			return result;
		}
	}
	
	
	
	/**
	 * Checks that the type is the same already used in this structure. 
	 * The given number is checked against the delta: since that is the first data on which this structure is built upon, the delta defines the type used (Float, Double or BigDecimal)
	 * @param number the Object to check
	 * @return true if the argument can be stored in this structure
	 * @throws InconsistentNumberTypeException 
	 * @throws UnsupportedTypeException 
	 */
	public boolean isTypeConsistent(Number number) throws InconsistentNumberTypeException, UnsupportedTypeException {
		boolean result = false;
		if(!isProper(number)){
			throw new UnsupportedTypeException(number);
		}
		else{
			result = checkSameType(delta, number);
		}
		return result;
	}
	
	
	
}
