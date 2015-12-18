package org.dryomys.exceptions;

/**
 * This Exception reports that there's been an attempt to use an object of type
 * different from Float/Double/BigDecimal. Types different from those listed
 * above (and related auto-boxable primitives) are not allowed in the system.
 * 
 * @author gabriele
 * 
 */
public class UnsupportedTypeException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * default constructor
     */
    public UnsupportedTypeException() {
        super();
    }

    /**
     * Single string constructor
     * 
     * @param s
     *            the string passed to superclass.
     */
    public UnsupportedTypeException(String s) {
        super(s);
    }

    /**
     * A more detailed constructor, reporting information about the object
     * violating allowed types.
     * 
     * @param object
     *            the not allowed object.
     */
    public UnsupportedTypeException(Object object) {
        super(
                "ATTENTION! ONLY SUPPORTED TYPES ARE: Float, Double, BigDecimal \n You used a "
                        + object.getClass().getName());
    }

}
