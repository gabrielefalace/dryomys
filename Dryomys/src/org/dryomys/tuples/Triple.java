package org.dryomys.tuples;


/**
 * 
 * A Tuple in a 3D space
 * 
 * @author gabriele
 *
 */
public class Triple extends Tuple {
	
	/**
	 *  the dimension of this Tuple
	 */
	public static final int DIMENSION = 3;
	
	/**
	 * Constructor for the Triple
	 * @param values explicit list or array of Number which form this Triple
	 */
	public Triple(Number ... values){
		super(values);
		if(values.length != DIMENSION){
			throw new RuntimeException("Cannot create a Pair with " + values.length + " values. There must be exactly 3 values! ");
		}
	}
	
	
	@Override
	public String toString(){
		return super.toString();
	}
}
