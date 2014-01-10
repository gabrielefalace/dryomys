package util.numericutils;

import static org.dryomys.util.NumericUtils.*;
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
public class FloatComparisonsTest {

    float firstFloat, secondFloat;
    boolean strictness;
    
    final Logger log = LoggerFactory.getLogger(FloatComparisonsTest.class);

    /**
     * 
     * @param firstOperand
     * @param secondOperand
     * @param strict
     */
    public FloatComparisonsTest(Object firstOperand, Object secondOperand,
            boolean strict) {
        firstFloat = ((Float) firstOperand).floatValue();
        secondFloat = ((Float) secondOperand).floatValue();
        this.strictness = strict;
    }

    /**
     * 
     * @return
     */
    @Parameterized.Parameters
    public static Collection testFloat() {
        Object[][] params = { { new Float(13.5f), new Float(6.88f), true },
                { new Float(55.5f), new Float(6.5f), false },
                { new Float(55.5f), new Float(55.5f), false },
                { new Float(1223.5f), new Float(346.88f), true },
                { new Float(5445.5f), new Float(886.5f), false },
                { new Float(5115.5f), new Float(5115.5f), false }, };
        return Arrays.asList(params);
    }

    /**
     * 
     */
    @Test
    public void testFloatPrimitives() {
        try {
            if (strictness) {
                assertTrue(greaterThan(firstFloat, secondFloat, strictness));
                assertTrue(lessThan(secondFloat, firstFloat, !strictness));
            } else if (!strictness) {

                boolean equal = firstFloat == secondFloat;

                assertTrue(greaterThan(firstFloat, secondFloat, strictness)
                        || equal);
                assertTrue(lessThan(secondFloat, firstFloat, !strictness)
                        || equal);
            }

        } catch (UnsupportedTypeException | InconsistentNumberTypeException unte) {
            log.error(" error testing float primitives ", unte);
            fail(EXCEPTION_FAIL_STRING);
        }
    }
}
