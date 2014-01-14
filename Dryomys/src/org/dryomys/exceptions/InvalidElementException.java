package org.dryomys.exceptions;

/**
 * 
 * @author gabriele
 * 
 */
@SuppressWarnings("serial")
public class InvalidElementException extends RuntimeException {

    /**
     * 
     */
    public InvalidElementException() {
        super(Messages.INVALID_ELEMENT.toString());
    }

    /**
     * 
     * @param msg
     * @param cause
     */
    public InvalidElementException(Throwable cause) {
        super(Messages.INVALID_ELEMENT.toString(), cause);
    }

}
