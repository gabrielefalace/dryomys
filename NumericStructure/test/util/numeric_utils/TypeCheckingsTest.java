package util.numeric_utils;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import core.TestDataFactory;
import util.NumericUtils;
import static org.junit.Assert.*;



public class TypeCheckingsTest {

	static NumericUtils numericUtils;
	
	static BigDecimal bigDecimalObject;
	static Double doubleObject;
	static Float floatObject;
	
	static float floatPrimitive;
	static double doublePrimitive;
	
	
	@BeforeClass
	public static void init(){
		numericUtils = NumericUtils.getInstance();
		
		bigDecimalObject = TestDataFactory.createBigDecimal();
		doubleObject = TestDataFactory.createDouble();
		floatObject = TestDataFactory.createFloat();
		
		floatPrimitive = TestDataFactory.createFloatPrimitive();
		doublePrimitive = TestDataFactory.createDoublePrimitive();
		
	}
	
	
	@Test
	public void testSupportedTypes(){
		assertTrue(numericUtils.isProper(bigDecimalObject));
		assertTrue(numericUtils.isProper(floatObject));
		assertTrue(numericUtils.isProper(doubleObject));
		assertTrue(numericUtils.isProper(doublePrimitive));
		assertTrue(numericUtils.isProper(floatPrimitive));
	}
	
	
	@Test
	public void testDouble(){
		assertTrue(numericUtils.isDouble(doubleObject));
		assertTrue(numericUtils.isDouble(doublePrimitive));
	}
	
	
	@Test
	public void testFloat(){
		assertTrue(numericUtils.isFloat(floatObject));
		assertTrue(numericUtils.isFloat(floatPrimitive));
	}
	
	@Test
	public void tesBigDecimal(){
		assertTrue(numericUtils.isBigDecimal(bigDecimalObject));
	}

}
