package util.numericutils;

import static org.dryomys.util.NumericUtils.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static core.TestDataFactory.*;

import java.math.BigDecimal;

import org.dryomys.exceptions.UnsupportedTypeException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author gabriele
 *
 */
public class SameTypeTest {

    static final BigDecimal BIG_DECIMAL_1 = new BigDecimal("223232324242375263587423685734653478546738736736873466857853873434835848.5893479863475865679756958657689576598676895");
    static final BigDecimal BIG_DECIMAL_2 = new BigDecimal("423895734986778685656834634867384567348768343684756345736485475834653847563874563487384.2365872435638475634758634875364");
    
    final Logger log = LoggerFactory.getLogger(SameTypeTest.class);
    
    /**
     * 
     */
    @Test
    public void testDoubleSucceeding() {
        Double d1 = new Double(3.553d);
        Double d2 = new Double(27.553d);
        try {
            boolean outcome = checkSameType(d1, d2);
            assertTrue(outcome);
        } catch (UnsupportedTypeException unsupported) {
            log.error(EXCEPTION_FAIL_STRING, unsupported);
            fail(EXCEPTION_FAIL_STRING);
        }
    }

    /**
     * 
     */
    @Test
    public void testDoubleFailing() {
        Double d1 = new Double(3.553d);
        Float f2 = new Float(27.553f);
        try {
            boolean outcome = checkSameType(d1, f2);
            assertFalse(outcome);
        } catch (UnsupportedTypeException unsupported) {
            log.error(EXCEPTION_FAIL_STRING, unsupported);
            fail(EXCEPTION_FAIL_STRING);
        }
    }

    // Test Float
    /**
     * 
     */
    @Test
    public void testFloatSucceeding() {
        Float f1 = new Float(3.553f);
        Float f2 = new Float(27.553f);
        try {
            boolean outcome = checkSameType(f1, f2);
            assertTrue(outcome);
        } catch (UnsupportedTypeException unsupported) {
            log.error(EXCEPTION_FAIL_STRING, unsupported);
            fail(EXCEPTION_FAIL_STRING);
        }
    }

    /**
     * 
     */
    @Test
    public void testFloatFailing() {
        Float f1 = new Float(3.553f);
        Double d2 = new Double(27.553d);
        try {
            boolean outcome = checkSameType(f1, d2);
            assertFalse(outcome);
        } catch (UnsupportedTypeException unsupported) {
            log.error(EXCEPTION_FAIL_STRING, unsupported);
            fail(EXCEPTION_FAIL_STRING);
        }
    }

    // Test double (primitive)
    /**
     * 
     */
    @Test
    public void testDoublePrimitiveSucceeding() {
        Double d1 = new Double(3.553d);
        double d2 = 27.553d;
        double d3 = 99.746d;

        try {
            boolean outcome1 = checkSameType(d1, d2);
            boolean outcome2 = checkSameType(d2, d3);
            boolean outcome3 = checkSameType(d1, d3);
            assertTrue(outcome1);
            assertTrue(outcome2);
            assertTrue(outcome3);
        } catch (UnsupportedTypeException unsupported) {
            log.error(EXCEPTION_FAIL_STRING, unsupported);
            fail(EXCEPTION_FAIL_STRING + unsupported.getMessage());
        }
    }

    /**
     * 
     */
    @Test
    public void testDoublePrimitiveFailing() {
        Double d1 = new Double(3.553d);
        float f2 = 27.553f;
        double d3 = 99.746d;
        BigDecimal b4 = new BigDecimal("23.3");

        try {
            boolean outcome1 = checkSameType(d1, f2);
            boolean outcome2 = checkSameType(f2, d3);
            boolean outcome3 = checkSameType(d3, b4);
            boolean outcome4 = checkSameType(d1, b4);
            assertFalse(outcome1);
            assertFalse(outcome2);
            assertFalse(outcome3);
            assertFalse(outcome4);
        } catch (UnsupportedTypeException unsupported) {
            log.error(EXCEPTION_FAIL_STRING, unsupported);
            fail(EXCEPTION_FAIL_STRING);
        }
    }

    // Test float (primitive)
    /**
     * 
     */
    @Test
    public void testFloatPrimitiveSucceeding() {
        Float f1 = new Float(3.553f);
        float f2 = 27.553f;
        float f3 = 99.746f;

        try {
            boolean outcome1 = checkSameType(f1, f2);
            boolean outcome2 = checkSameType(f2, f3);
            boolean outcome3 = checkSameType(f1, f3);
            assertTrue(outcome1);
            assertTrue(outcome2);
            assertTrue(outcome3);
        } catch (UnsupportedTypeException unsupported) {
            log.error(EXCEPTION_FAIL_STRING, unsupported);
            fail(EXCEPTION_FAIL_STRING);
        }
    }

    /**
     * 
     */
    @Test
    public void testFloatPrimitiveFailing() {
        Float f1 = new Float(3.553d);
        float f2 = 27.553f;
        double d3 = 99.746d;
        BigDecimal b4 = new BigDecimal("23.3");

        try {
            boolean outcome1 = checkSameType(f1, f2);
            boolean outcome2 = checkSameType(f2, d3);
            boolean outcome3 = checkSameType(f2, b4);
            boolean outcome4 = checkSameType(f1, b4);

            assertTrue(outcome1);

            assertFalse(outcome2);
            assertFalse(outcome3);
            assertFalse(outcome4);
        } catch (UnsupportedTypeException unsupported) {
            log.error(EXCEPTION_FAIL_STRING, unsupported);
            fail(EXCEPTION_FAIL_STRING);
        }
    }

    // Test BigDecimal

    /**
     * 
     */
    @Test
    public void testBigDecimalSucceeding() {
        try {
            boolean outcome = checkSameType(BIG_DECIMAL_1, BIG_DECIMAL_2);
            assertTrue(outcome);
        } catch (UnsupportedTypeException unsupported) {
            log.error(EXCEPTION_FAIL_STRING, unsupported);
            fail(EXCEPTION_FAIL_STRING);            
        }
    }

    /**
     * 
     */
    @Test
    public void testBigDecimalFailing() {
        double d2 = 23.5d;
        Double d3 = new Double(494.3d);
        float f4 = 12.2f;
        Float f5 = new Float(23.77f);
        try {
            boolean outcome1 = checkSameType(BIG_DECIMAL_1, d2);
            boolean outcome2 = checkSameType(BIG_DECIMAL_1, d3);
            boolean outcome3 = checkSameType(BIG_DECIMAL_1, f4);
            boolean outcome4 = checkSameType(BIG_DECIMAL_1, f5);

            assertFalse(outcome1);
            assertFalse(outcome2);
            assertFalse(outcome3);
            assertFalse(outcome4);

        } catch (UnsupportedTypeException unsupported) {
            log.error(EXCEPTION_FAIL_STRING, unsupported);
            fail(EXCEPTION_FAIL_STRING);
        }
    }

}
