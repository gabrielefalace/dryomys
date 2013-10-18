package distance;

import exceptions.UnsupportedNumberTypeException;

public interface DistanceProvider<T> {

	public Number distance(T firstElement, T secondElement) throws UnsupportedNumberTypeException;
	
}
