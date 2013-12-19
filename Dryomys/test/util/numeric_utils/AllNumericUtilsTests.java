package util.numeric_utils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ ObjectComparisonsTest.class, 
				FloatComparisonsTest.class,
				DoubleComparisonsTest.class,
				SameTypeTest.class,
				TypeCheckingsTest.class})
public class AllNumericUtilsTests {
}
