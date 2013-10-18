package tuples;


/*
 * TODO under construction ... 
 * 
 */
public class Triple extends Tuple {
	
	public static final int DIMENSION = 3;
	
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
