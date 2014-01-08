package org.dryomys.util;

import java.math.BigDecimal;
import org.dryomys.exceptions.ExceptionFactory;
import org.dryomys.exceptions.UnsupportedTypeException;

/**
 * 
 * This class provides several functionalities to manipulate Number objects and
 * their related primitives. The behavior is based on the DistanceProvider
 * object, which is the DefaultDistanceProvider. If the user wants to use a
 * different DistanceProvider, the setDistanceProvider() method should be used.
 * 
 * @author Gabriele Falace
 */
public final class NumericUtils {

    /**
     * Private constructor to impede instantiation
     */
    private NumericUtils() {
    }

    /**
     * this value means that a comparison operator has to be intended as strict
     * (i.e. "<" and ">")
     */
    public static final boolean STRICT = true;

    /**
     * this value means that a comparison operator has to be intended as strict
     * (i.e. <= and >=)
     */
    public static final boolean NON_STRICT = false;

    /**
     * Checks if the passed Number is exactly in this collection, using equals.
     * This method does not rely on the approximately equals concept
     * 
     * @param number
     *            the Number to be found
     * @param array
     *            the array in which the search is to be performed
     * @return true if the element is found, false otherwise
     */
    public static final boolean isExactlyIn(Number number, Number[] array) {
        boolean outcome = false;
        for (Number iter : array) {
            if (number.equals(iter)) {
                outcome = true;
                break;
            }
        }
        return outcome;
    }

    /**
     * Checks if a number is bigger then another.
     * 
     * @param n1
     *            a Number to compare
     * @param n2
     *            the other Number to compare
     * @param strictness
     *            if set to true, it has a ">" semantic, otherwise it means ">="
     * @return a boolean given by strictness==true? n1>n2 : n1>=n2
     * @throws UnsupportedTypeException
     */
    public static final boolean greaterThan(Number n1, Number n2,
            boolean strictness) throws UnsupportedTypeException {
        return !lessThan(n1, n2, !strictness);
    }

    /**
     * Checks if a number is smaller then another.
     * 
     * @param n1
     *            a Number to compare
     * @param n2
     *            the other Number to compare
     * @param strictness
     *            if set to true, it has a "<" semantic, otherwise it means "<="
     * @return a boolean given by strictness==true? n1<n2 : n1<=n2
     * @throws UnsupportedTypeException
     */
    public static final boolean lessThan(Number n1, Number n2, boolean strictness) throws UnsupportedTypeException {
        boolean result = false;
        BigDecimal bd1 = (BigDecimal) n1;
        BigDecimal bd2 = (BigDecimal) n2;
        int comparison = bd1.compareTo(bd2);
        result = strictness ? comparison == -1 : comparison <= 0;
        return result;
    }

    /**
     * Checks if two given Number are actually instances of the same class.
     * 
     * @param n1
     *            the first Number to be compared
     * @param n2
     *            the second Number to be compared
     * @return true if the two Number are from the same class
     * @throws UnsupportedTypeException
     *             when Number is not Float, Double or BigDecimal
     */
    public static final boolean checkSameType(Number n1, Number n2)
            throws UnsupportedTypeException {
        if (isProper(n1) && isProper(n2)) {

            boolean result = false;
            String typeN1 = n1.getClass().getName();
            String typeN2 = n2.getClass().getName();

            if (typeN1.equals(typeN2)) {
                result = true;
            }
            return result;
        } else {
            throw ExceptionFactory.createUnsupportedNumberType(n1, n2);
        }
    }

    /**
     * Checks if a given Object is of one of the supported types: Float, Double
     * or BigDecimal
     * 
     * @param object
     *            the object to be checked
     * @return true if the object is one of the supported types
     */
    public static final boolean isProper(Number object) {
        return isFloat(object) || isDouble(object) || isBigDecimal(object);
    }

    /**
     * Tests if a given Object is a Float
     * 
     * @param object
     *            the Object to test
     * @return true if the argument is a Float
     */
    public static final boolean isFloat(Object object) {
        return object instanceof Float;
    }

    /**
     * Tests if a given Object is a Double
     * 
     * @param object
     *            the Object to test
     * @return true if the argument is a Double
     */
    public static final boolean isDouble(Object object) {
        return object instanceof Double;
    }

    /**
     * Tests if a given Object is a BigDecimal
     * 
     * @param object
     *            the Object to test
     * @return true if the argument is a BigDecimal
     */
    public static final boolean isBigDecimal(Object object) {
        return object instanceof BigDecimal;
    }

    /*
     * Piece of code taken from a website:
     * 
     * sqrt-function copied of BigFunctionsClassrom From The Java Programmers
     * Guide To numerical Computing (Ronald Mak, 2003)
     */

}
