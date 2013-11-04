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
public class DoubleComparisonsTest {
	
	
	double firstDouble, secondDouble;
	
	boolean strictness;
	
	
	public DoubleComparisonsTest (Object firstOperand, Object secondOperand, boolean strict){
		firstDouble = ((Double)firstOperand).doubleValue();
		secondDouble = ((Double)secondOperand).doubleValue();
		this.strictness = strict;
	}
	
	
	@BeforeClass
	public static void initialize(){
		
	}
	
	
	@Parameterized.Parameters
	public static Collection prepareParameters(){
		Object[][] params = {
				{new Double(13.5d), new Double(6.88d), true},
				{new Double(55.5d), new Double(6.5d), false},
				{new Double(55.5d), new Double(55.5d), false},
				{new Double(1223.5d), new Double(346.88d), true},
				{new Double(5445.5d), new Double(886.5d), false},
				{new Double(5115.5d), new Double(5115.5d), false},
		};
		return Arrays.asList(params);
	}
	
	@Test
	public void testDoublePrimitives(){
		try{
			if(strictness){
				assertTrue(greaterThan(firstDouble, secondDouble, strictness));
				assertTrue(lessThan(secondDouble, firstDouble, !strictness));
			}
			else if(!strictness){
				
				boolean equal = firstDouble==secondDouble;
				
				assertTrue(greaterThan(firstDouble, secondDouble, strictness) || equal);
				assertTrue(lessThan(secondDouble, firstDouble, !strictness) || equal);
			}
		}
		catch(UnsupportedTypeException unte){
			unte.printStackTrace();
		}
	}
}
