package org.dryomys.exceptions;

/**
 * 
 * @author gabriele
 * 
 */
public class NullComputedException extends RuntimeException {

    /**
     * 
     */
    public NullComputedException() {
        super(Messages.NULL_COMPUTED.toString());
    }

    /**
     * 
     * @param cause
     */
    public NullComputedException(Throwable cause) {
        super(Messages.NULL_COMPUTED.toString(), cause);
    }
}
