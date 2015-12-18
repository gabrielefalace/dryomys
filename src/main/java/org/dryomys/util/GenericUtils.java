package org.dryomys.util;

import java.util.Collection;

/**
 * 
 * @author gabriele
 * 
 */
public class GenericUtils {

    /**
     * Private constructor to impede instantiation
     */
    private GenericUtils() {
    }

    /**
     * 
     * @param objects
     * @return
     */
    public static final boolean noNull(Object... objects) {
        boolean result = true;
        for (Object o : objects) {
            if (o == null) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 
     * @param objects
     * @return
     */
    public static final boolean noNull(Collection<?> objects) {
        boolean result = true;
        for (Object o : objects) {
            if (o == null) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 
     * @param objects
     * @return
     */
    public static final boolean hasSomeNull(Collection<?> objects) {
        return !noNull(objects);
    }

    /**
     * 
     * @param objects
     * @return
     */
    public static final boolean hasSomeNull(Object... objects) {
        return !noNull(objects);
    }

}
