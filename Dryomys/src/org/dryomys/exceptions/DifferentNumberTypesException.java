package org.dryomys.exceptions;

/**
 * This class represents the Exception that has to be thrown when the numbers provided to some operation are not of the same type.
 * 
 * @author gabriele
 *
 */
public class DifferentNumberTypesException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * default constructor
	 */
	public DifferentNumberTypesException(){
		super();
	}
	
	/**
	 * Single string constructor
	 * @param s the string passed to superclass.
	 */
	public DifferentNumberTypesException(String s){
		super(s);
	}
	
	/**
	 * A more detailed constructor, reporting also information about the objects causing the exception.
	 * @param n1 the first object 
	 * @param n2 the second object
	 */
	public DifferentNumberTypesException(Number n1, Number n2){
		super("Number you provided are not of the same class: one is "+n1.getClass().getName()+" while the ohter is "+n2.getClass().getName());
	}

}
