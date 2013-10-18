package tuples;

/*
 * TODO under construction ... 
 * 
 */
public class Element extends Tuple {

	public static final int DIMENSION = 1;
	
	public Element(Number ... values){
		super(values);
		if(values.length != DIMENSION){
			throw new RuntimeException("Cannot create a Pair with " + values.length + " values. There must be exactly 1 value! ");
		}
	}
	
	
}
