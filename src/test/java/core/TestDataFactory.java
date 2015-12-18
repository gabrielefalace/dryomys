package core;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 
 * @author gabriele
 *
 */
public class TestDataFactory {

    /**
     * A string which represent a prefix for when a test is failed due to an exception
     */
    public static final String EXCEPTION_FAIL_STRING = "Shouldn't have thrown this: ";
    
    private static final Random RANDOM_GENERATOR;

    static {
        RANDOM_GENERATOR = new Random();
    }

    private TestDataFactory(){
    }
    
    /**
     * 
     * @return
     */
    public static final Float createFloat() {
        // will be autoboxed automatically
        return RANDOM_GENERATOR.nextFloat(); 
    }

    /**
     * 
     * @return
     */
    public static final float createFloatPrimitive() {
        return RANDOM_GENERATOR.nextFloat();
    }

    /**
     * 
     * @return
     */
    public static final Double createDouble() {
        // will be autoboxed automatically
        return RANDOM_GENERATOR.nextDouble(); 
    }

    /**
     * 
     * @return
     */
    public static final double createDoublePrimitive() {
        return RANDOM_GENERATOR.nextDouble();
    }

    /**
     * 
     * @return
     */
    public static final BigDecimal createBigDecimal() {
        StringBuilder result = new StringBuilder();
        String[] digits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

        // first digit shouldn't be zero:
        int index = RANDOM_GENERATOR.nextInt(9) + 1;
        result.append("" + digits[index]);

        // remaining whole part
        for (int i = 0; i < 25; i++) {
            index = RANDOM_GENERATOR.nextInt(9);
            result.append("" + digits[index]);
        }

        result.append(".");

        // decimal part
        for (int i = 0; i < 25; i++) {
            index = RANDOM_GENERATOR.nextInt(9);
            result.append("" + digits[index]);
        }
        String resultString = result.toString();

        return new BigDecimal(resultString);
    }

}
