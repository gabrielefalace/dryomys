package tuples;


/**
 * 
 * A Tuple in a 2D space
 * 
 * @author gabriele
 *
 */
public class Pair extends Tuple {

	/**
	 *  the dimension of this Tuple
	 */
	public static final int DIMENSION = 2;
	
	/**
	 * Constructor for the Pair
	 * @param values explicit list or array of Number which form this Pair
	 */
	public Pair(Number ... values){
		super(values);
		if(values.length != DIMENSION){
			throw new RuntimeException("Cannot create a Pair with " + values.length + " values. There must be exactly 2 values! ");
		}
	}
	
	
	@Override
	public String toString(){
		return super.toString();
	}
	
}
