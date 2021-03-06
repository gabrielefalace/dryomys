package util.numericutils;

import static core.TestDataFactory.EXCEPTION_FAIL_STRING;
import static org.dryomys.util.NumericUtils.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.dryomys.exceptions.InconsistentNumberTypeException;
import org.dryomys.exceptions.UnsupportedTypeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author gabriele
 * 
 */
@RunWith(Parameterized.class)
public class ObjectComparisonsTest {

    Number first, second;
    boolean strictness;

    final Logger logger = LoggerFactory.getLogger(ObjectComparisonsTest.class);

    /**
     * 
     * @param firstOperand
     * @param secondOperand
     * @param strict
     */
    public ObjectComparisonsTest(Object firstOperand, Object secondOperand,
            boolean strict) {
        this.first = (Number) firstOperand;
        this.second = (Number) secondOperand;
        this.strictness = strict;
    }

    /**
     * 
     * @return
     */
    @Parameterized.Parameters
    public static Collection testNumbers() {
        Object[][] params = {
                { new Float(13.5f), new Float(6.88f), true },
                { new Float(55.5f), new Float(6.5f), false },
                { new Float(55.5f), new Float(55.5f), false },
                { new Double(1223.5d), new Double(346.88d), true },
                { new Double(5445.5d), new Double(886.5d), false },
                { new Double(5115.5d), new Double(5115.5d), false },
                { new BigDecimal("548835746"), new BigDecimal("5488346"), true },
                { new BigDecimal("895983245892"), new BigDecimal("58388585"),
                        false },
                {
                        new BigDecimal(
                                "9948679932582096720968363476896437689.2343756348538675757645347563453475213809140"),
                        new BigDecimal(
                                "32582096720968363476896437689.2752685628576248754365783463587436"),
                        false } };
        return Arrays.asList(params);
    }

    /**
     * 
     */
    @Test
    public void testObjects() {
        try {
            if (strictness) {
                assertTrue(greaterThan(first, second, strictness));
                assertTrue(lessThan(second, first, !strictness));
            } else if (!strictness) {

                boolean equal = first.equals(second);

                assertTrue(greaterThan(first, second, strictness) || equal);
                assertTrue(lessThan(second, first, !strictness) || equal);
            }

        } catch (UnsupportedTypeException | InconsistentNumberTypeException unte) {
            logger.error("object test failed ", unte);
            fail(EXCEPTION_FAIL_STRING);
        }
    }
}
