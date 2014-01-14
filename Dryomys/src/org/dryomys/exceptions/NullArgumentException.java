package org.dryomys.exceptions;

/**
 * 
 * @author gabriele
 * 
 */
@SuppressWarnings("serial")
public class NullArgumentException extends RuntimeException {

    /**
     * 
     */
    public NullArgumentException() {
        super(Messages.NULL_ARGUMENT.toString());
    }

    /**
     * 
     * @param cause
     */
    public NullArgumentException(Throwable cause) {
        super(Messages.NULL_ARGUMENT.toString(), cause);
    }
}
