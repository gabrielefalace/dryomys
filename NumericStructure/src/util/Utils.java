package util;

import exceptions.UnsupportedTypeException;

/**
 * This interface defines the set of operations that "Utils" classes must have in this library. 
 * 
 * @author gabriele
 * @param <T> the type T of the objects that will be manipulated by "Utils" classes
 */
public interface Utils<T> {

	/**
	 * Retrieves the element in the array argument having the smallest distance to the passed element
	 * @param element the element against which to compare
	 * @param array the array to search in
	 * @return the closest T element in the array
	 * @throws UnsupportedTypeException whenever an unsupported type is encountered
	 */
	public T getClosest(T element, T[] array)  throws UnsupportedTypeException;
	
	
	/**
	 * Tests if two passed Objects of type T are approximately equals, according to a threshold named delta.
	 * @param first the first T element
	 * @param second the second T element
	 * @param delta the delta to be used in comparing the arguments
	 * @return true if first is approximately equal to second, false otherwise
	 * @throws UnsupportedTypeException if an argument is of an unsupported type
	 */
	public boolean approximatelyEqual(T first, T second, Number delta)  throws UnsupportedTypeException;
	
	
	/**
	 * Tests if a given element is actually in the array passed. It's not approximate!
	 * @param number the T to search
	 * @param array the array of T to search in
	 * @return true if the element is found, false otherwise
	 */
	public boolean isExactlyIn(T number, T[] array);
	
	
	/**
	 * Checks if the T element is constituted of only allowed data types.
	 * @param element the T object to check
	 * @return true if the object is ok, false otherwise
	 */
	//TODO REFACTOR THIS NAME!!!
	public boolean isProper(T element);
	
}
