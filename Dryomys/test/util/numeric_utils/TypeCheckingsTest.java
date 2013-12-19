package util.numeric_utils;

import java.math.BigDecimal;

import org.dryomys.util.NumericUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import core.TestDataFactory;
import static org.dryomys.util.NumericUtils.*;
import static org.junit.Assert.*;



public class TypeCheckingsTest {


	static BigDecimal bigDecimalObject;
	static Double doubleObject;
	static Float floatObject;
	
	static float floatPrimitive;
	static double doublePrimitive;
	
	
	@BeforeClass
	public static void init(){
	
		bigDecimalObject = TestDataFactory.createBigDecimal();
		doubleObject = TestDataFactory.createDouble();
		floatObject = TestDataFactory.createFloat();
		
		floatPrimitive = TestDataFactory.createFloatPrimitive();
		doublePrimitive = TestDataFactory.createDoublePrimitive();
		
	}
	
	
	@Test
	public void testSupportedTypes(){
		assertTrue(isProper(bigDecimalObject));
		assertTrue(isProper(floatObject));
		assertTrue(isProper(doubleObject));
		assertTrue(isProper(doublePrimitive));
		assertTrue(isProper(floatPrimitive));
	}
	
	
	@Test
	public void testDouble(){
		assertTrue(isDouble(doubleObject));
		assertTrue(isDouble(doublePrimitive));
	}
	
	
	@Test
	public void testFloat(){
		assertTrue(isFloat(floatObject));
		assertTrue(isFloat(floatPrimitive));
	}
	
	@Test
	public void tesBigDecimal(){
		assertTrue(isBigDecimal(bigDecimalObject));
	}

}
