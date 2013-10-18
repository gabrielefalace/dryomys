package util;

import exceptions.UnsupportedNumberTypeException;

public interface Utils<T> {

	
	public T getClosest(T element, T[] array)  throws UnsupportedNumberTypeException;
	
	public boolean approximatelyEqual(T first, T second, Number delta)  throws UnsupportedNumberTypeException;
	
	public boolean isExactlyIn(T number, T[] array);
	
	public boolean isProper(T element);
	
}
