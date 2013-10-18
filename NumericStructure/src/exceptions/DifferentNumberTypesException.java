package exceptions;

public class DifferentNumberTypesException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DifferentNumberTypesException(){
		super();
	}
	
	
	public DifferentNumberTypesException(String s){
		super(s);
	}
	
	
	public DifferentNumberTypesException(Number n1, Number n2){
		super("Number you provided are not of the same class: one is "+n1.getClass().getName()+" while the ohter is "+n2.getClass().getName());
	}

}
