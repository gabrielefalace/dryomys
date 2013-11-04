package util.numeric_utils;

import static org.junit.Assert.assertTrue;
import static util.NumericUtils.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import exceptions.UnsupportedTypeException;

@RunWith(Parameterized.class)
public class FloatComparisonsTest {
	
	
	float firstFloat, secondFloat;
	
	boolean strictness;
	
	
	public FloatComparisonsTest (Object firstOperand, Object secondOperand, boolean strict){
		firstFloat = ((Float)firstOperand).floatValue();
		secondFloat = ((Float)secondOperand).floatValue();
		this.strictness = strict;
	}
	
	
	@BeforeClass
	public static void initialize(){
		
	}
	
	
	@Parameterized.Parameters
	public static Collection testFloat(){
		Object[][] params = {
				{new Float(13.5f), new Float(6.88f), true},
				{new Float(55.5f), new Float(6.5f), false},
				{new Float(55.5f), new Float(55.5f), false},
				{new Float(1223.5f), new Float(346.88f), true},
				{new Float(5445.5f), new Float(886.5f), false},
				{new Float(5115.5f), new Float(5115.5f), false},
		};
		return Arrays.asList(params);
	}
	
	@Test
	public void testFloatPrimitives(){
		try{
			if(strictness){
				assertTrue(greaterThan(firstFloat, secondFloat, strictness));
				assertTrue(lessThan(secondFloat, firstFloat, !strictness));
			}
			else if(!strictness){
				
				boolean equal = firstFloat==secondFloat;
				
				assertTrue(greaterThan(firstFloat, secondFloat, strictness) || equal);
				assertTrue(lessThan(secondFloat, firstFloat, !strictness) || equal);
			}
		
		}
		catch(UnsupportedTypeException unte){
			unte.printStackTrace();
		}
	}
}
