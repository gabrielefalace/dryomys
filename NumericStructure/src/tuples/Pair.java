package tuples;


/*
 * TODO under construction ... 
 * 
 */
public class Pair extends Tuple {

	public static final int DIMENSION = 2;
	
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
