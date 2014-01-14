package org.dryomys.core;

import java.util.Collection;

import org.dryomys.exceptions.ExceptionFactory;
import org.dryomys.exceptions.InconsistentNumberTypeException;
import org.dryomys.exceptions.UnsupportedTypeException;

import static org.dryomys.util.NumericUtils.*;

/**
 * 
 * VERIFY: CLASSES EXTENDING THIS DO NOT SUPPORT NULL VALUES!
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
    protected static NumericEngine engine = NumericEngine.getInstance();

    /**
     * Retrieves the current delta value
     * 
     * @return the delta
     */
    public Number getDelta() {
        return this.delta;
    }

    /**
     * Returns the data type allowed in this structure
     * 
     * @return a String that is the class name of the delta, which constraints
     *         the type of data this structure should hold
     * @throws UnsupportedTypeException
     */
    public String getStructureType() throws UnsupportedTypeException {
        String result = delta.getClass().getName();
        if (result == null) {
            throw ExceptionFactory.createUnsupportedNumberType(delta);
        } else {
            return result;
        }
    }

    /**
     * Checks that the type is the same already used in this structure. The
     * given number is checked against the delta: since that is the first data
     * on which this structure is built upon, the delta defines the type used
     * (Float, Double or BigDecimal)
     * 
     * @param number
     *            the Object to check
     * @return true if the argument can be stored in this structure
     * @throws UnsupportedTypeException when an unsupported type is used
     */
    public boolean isTypeConsistent(Number number)
            throws UnsupportedTypeException {
        boolean result = false;
        if (!isProper(number)) {
            throw new UnsupportedTypeException(number);
        } else {
            result = checkSameType(delta, number);
        }
        return result;
    }

    /**
     * 
     * @param element the element that we check
     * @param collection the collection against which the element is checked
     * @return boolean true if the element has to be retained, false otherwise
     * @throws UnsupportedTypeException if an unsupported type is used
     * @throws InconsistentNumberTypeException if two incompatible type Numbers get compared
     */
    public static final boolean isToRetain(Number element, Collection<Number> collection, Number delta)
            throws UnsupportedTypeException, InconsistentNumberTypeException{
        boolean result = false;
        for (Number passed : collection) {
            if (engine.approximatelyEqual(element, passed, delta)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
