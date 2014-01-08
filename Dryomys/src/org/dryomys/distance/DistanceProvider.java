package org.dryomys.distance;

import org.dryomys.exceptions.UnsupportedTypeException;

/**
 * This interface represents an object having the capability to make
 * distance-based calculations between objects of type T.
 * 
 * @author gabriele
 * 
 * @param <T>
 *            the type of objects to make calculations on.
 */
public interface DistanceProvider<T> {
    /**
     * 
     * Defines the distance between two objects of the given type T.
     * 
     * @param firstElement
     *            the first element of type T to use
     * @param secondElement
     *            the first element of type T to use
     * @return the distance between the two elements
     * @throws UnsupportedTypeException
     *             when objects passed in are not Float/Double/BigDecimal
     */
    Number distance(T firstElement, T secondElement)
            throws UnsupportedTypeException;
}