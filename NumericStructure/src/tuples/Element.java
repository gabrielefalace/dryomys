package tuples;

/**
 * 
 * A Tuple of dimension 1, actually just a wrapped Number.
 * 
 * @author gabriele
 *
 */
public class Element extends Tuple {

	/**
	 *  the dimension of this Tuple
	 */
	public static final int DIMENSION = 1;
	
	/**
	 * Constructor for the Element
	 * @param values explicit list or array of Number which form this Element
	 */
	public Element(Number ... values){
		super(values);
		if(values.length != DIMENSION){
			throw new RuntimeException("Cannot create a Pair with " + values.length + " values. There must be exactly 1 value! ");
		}
	}
	
	
}
