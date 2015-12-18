package util.numericutils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author gabriele
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ ObjectComparisonsTest.class, FloatComparisonsTest.class,
        DoubleComparisonsTest.class, SameTypeTest.class,
        TypeCheckingsTest.class })
public class AllNumericUtilsTests {
}
