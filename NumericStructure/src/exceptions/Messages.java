package exceptions;

/**
 * This interface is designed just as a quick-access container for text messages.
 * 
 * @author gabriele
 *
 */
public interface Messages {
	
	
	/**
	 * Says that there's a null element (not allowed) in a collection
	 */
	public static final String NULL_IN_COLLECTION = new String("Found null value in collection");
	
	
	/**
	 * Says that a required argument is null
	 */
	public static final String NULL_ARGUMENT = new String("The passed argument is null");
	
	
	/**
	 * Says that a null element has been received by the caller as return of a method call
	 */
	public static final String NULL_RECEIVED = new String("An unexpected null value was received by the caller after a method call ");

}
