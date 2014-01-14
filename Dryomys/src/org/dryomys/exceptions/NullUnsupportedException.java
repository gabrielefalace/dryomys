package org.dryomys.exceptions;

/**
 * 
 * @author gabriele
 * 
 */
@SuppressWarnings("serial")
public class NullUnsupportedException extends RuntimeException {

    /**
     * 
     */
    public NullUnsupportedException() {
        super(Messages.NULL_IN_COLLECTION.toString());
    }

    /**
     * 
     * @param cause
     */
    public NullUnsupportedException(Throwable cause) {
        super(Messages.NULL_IN_COLLECTION.toString(), cause);
    }
}
