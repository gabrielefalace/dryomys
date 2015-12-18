package org.dryomys.exceptions;

/**
 * 
 * This Exception represent the usage of a non-consistent type (i.e. adding a
 * Double to a Float structure). Even if all the types used are allowed,
 * inconsistencies can always arise since they can be non consistent among
 * themselves.
 * 
 * @author gabriele
 * 
 */
public class InconsistentNumberTypeException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * default constructor
     */
    public InconsistentNumberTypeException() {
        super();
    }

    /**
     * Single string constructor
     * 
     * @param s
     *            the string passed to superclass.
     */
    public InconsistentNumberTypeException(String s) {
        super(s);
    }

    /**
     * A more detailed constructor, reporting also information about the
     * expected type and the type that has been actually used instead.
     * 
     * @param actual
     *            the object actually used
     * @param expected
     *            the object expected
     */
    public InconsistentNumberTypeException(Number actual, Number expected) {
        super("Exception: actual type " + actual.getClass().getName() + " while collection expected " + expected.getClass().getName());
    }

}
