package core;

import java.math.BigDecimal;
import java.util.Random;

public class TestDataFactory {
	
	private static final Random randomGenerator;
	
	static {
		randomGenerator = new Random();
	}
	
	
	
	public static final Float createFloat(){
		return randomGenerator.nextFloat();		// will be autoboxed automatically
	}
	
	
	public static final float createFloatPrimitive(){
		return randomGenerator.nextFloat();
	}
	
	
	public static final Double createDouble(){
		return randomGenerator.nextDouble();	// will be autoboxed automatically
	}
	
	public static final double createDoublePrimitive(){
		return randomGenerator.nextDouble();	
	}
	
	public static final BigDecimal createBigDecimal(){
		StringBuilder result = new StringBuilder();
		String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		// first digit shouldn't be zero:
		int index = randomGenerator.nextInt(9) + 1;
		result.append(""+digits[index]);
		
		// remaining whole part
		for(int i=0; i<25; i++){
			index = randomGenerator.nextInt(9);
			result.append(""+digits[index]);
		}
		
		result.append(".");
		
		// decimal part
		for(int i=0; i<25; i++){
			index = randomGenerator.nextInt(9);
			result.append(""+digits[index]);
		}
		String resultString = result.toString();
		
		return new BigDecimal(resultString);
	}

}
