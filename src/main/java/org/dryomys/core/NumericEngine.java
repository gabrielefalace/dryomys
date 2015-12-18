package org.dryomys.core;

import static org.dryomys.util.GenericUtils.*;

import org.dryomys.distance.DefaultDistanceProvider;
import org.dryomys.distance.DistanceProvider;
import org.dryomys.exceptions.InconsistentNumberTypeException;
import org.dryomys.exceptions.NullArgumentException;
import org.dryomys.exceptions.NullUnsupportedException;
import org.dryomys.exceptions.UnsupportedTypeException;
import org.dryomys.util.NumericUtils;
import org.eclipse.jdt.annotation.Nullable;

/**
 * 
 * @author gabriele
 * 
 */
public class NumericEngine {

    private DistanceProvider<Number> distanceProvider;

    private static NumericEngine engine = new NumericEngine();

    private NumericEngine() {
        distanceProvider = new DefaultDistanceProvider();
    }

    /**
     * 
     * @return the unique instance of NumericEngine
     */
    public static synchronized NumericEngine getInstance() {
        return engine;
    }

    /**
     * 
     * @return the DistanceProvider currently set
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
     * Finds the Number in the array which is closer to another given Number,
     * according to the DistanceProvider used.
     * 
     * @param number
     *            the number to be found
     * @param array
     *            the array of Number to search in
     * @return the Number in the array which has the minimum distance to the
     *         given number
     * @throws UnsupportedTypeException
     *             if Number used are not Float, Double or BigDecimal
     * @throws InconsistentNumberTypeException 
     */
    @Nullable
    public final Number getClosest(Number number, Number[] array)
            throws UnsupportedTypeException, InconsistentNumberTypeException {
        if (array.length == 0) {
            throw new NullArgumentException();
        }
        if (hasSomeNull((Object[]) array)) {
            throw new NullUnsupportedException();
        }
        Number currentBest = array[0];
        Number currentDist = distanceProvider.distance(currentBest, number);

        for (Number elem : array) {
            Number tmpDist = distanceProvider.distance(elem, number);
            if (noNull(tmpDist, currentDist)
                    && NumericUtils.lessThan(tmpDist, currentDist,
                            NumericUtils.STRICT)) {
                currentBest = elem;
                currentDist = tmpDist;
            }
        }
        return currentBest;
    }

    /**
     * Checks if two given Number are approximately equal, according to a given
     * level of approximation, delta. Formally using the distance function n1
     * and n2 are approximatelyEqual if distance(n1,n2) <= delta.
     * 
     * @param n1
     *            a Number
     * @param n2
     *            another Number
     * @param delta
     *            the tolerance for equality
     * @return true if the number are approximately equal
     * @throws UnsupportedTypeException
     *             when one of the arguments is not Float, Double or BigDecimal.
     * @throws InconsistentNumberTypeException if the two Number have incompatible types
     */
    public final boolean approximatelyEqual(Number n1, Number n2, Number delta)
            throws UnsupportedTypeException, InconsistentNumberTypeException{
        Number distance = distanceProvider.distance(n1, n2);
        boolean result = false;
        if (distance != null) {
            result = NumericUtils.lessThan(distance, delta, false);
        }
        return result;
    }

}
