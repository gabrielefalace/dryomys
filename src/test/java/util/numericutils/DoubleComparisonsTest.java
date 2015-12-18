package util.numericutils;

import static core.TestDataFactory.EXCEPTION_FAIL_STRING;
import static org.dryomys.util.NumericUtils.greaterThan;
import static org.dryomys.util.NumericUtils.lessThan;
import static org.junit.Assert.*;
import static core.TestDataFactory.*;

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
public class DoubleComparisonsTest {

    double firstDouble, secondDouble;
    boolean strictness;
    
    final Logger log = LoggerFactory.getLogger(DoubleComparisonsTest.class);

    /**
     * 
     * @param firstOperand
     * @param secondOperand
     * @param strict
     */
    public DoubleComparisonsTest(Object firstOperand, Object secondOperand,
            boolean strict) {
        firstDouble = ((Double) firstOperand).doubleValue();
        secondDouble = ((Double) secondOperand).doubleValue();
        this.strictness = strict;
    }

    /**
     * 
     * @return
     */
    @Parameterized.Parameters
    public static Collection prepareParameters() {
        Object[][] params = { { new Double(13.5d), new Double(6.88d), true },
                { new Double(55.5d), new Double(6.5d), false },
                { new Double(55.5d), new Double(55.5d), false },
                { new Double(1223.5d), new Double(346.88d), true },
                { new Double(5445.5d), new Double(886.5d), false },
                { new Double(5115.5d), new Double(5115.5d), false }, };
        return Arrays.asList(params);
    }

    /**
     * 
     */
    @Test
    public void testDoublePrimitives() {
        try {
            if (strictness) {
                assertTrue(greaterThan(firstDouble, secondDouble, strictness));
                assertTrue(lessThan(secondDouble, firstDouble, !strictness));
            } else if (!strictness) {

                boolean equal = firstDouble == secondDouble;

                assertTrue(greaterThan(firstDouble, secondDouble, strictness)
                        || equal);
                assertTrue(lessThan(secondDouble, firstDouble, !strictness)
                        || equal);
            }
        } catch (UnsupportedTypeException | InconsistentNumberTypeException unte) {
            log.error("error testing double primitives ", unte);
            fail(EXCEPTION_FAIL_STRING);
        }
    }
}
