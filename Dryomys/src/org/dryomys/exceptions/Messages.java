package org.dryomys.exceptions;

/**
 * This interface is designed just as a quick-access container for text
 * messages.
 * 
 * @author gabriele
 * 
 */
public enum Messages {

    /**
     * Says that there's a null element (not allowed) in a collection
     */
    NULL_IN_COLLECTION,

    /**
     * Says that a required argument is null
     */
    NULL_ARGUMENT,

    /**
     * Says that a null element has been received by the caller as return of a
     * method call
     */
    NULL_COMPUTED,

    /**
     * Says that user attempted an operation with an element of a not-allowed
     * type
     */
    INVALID_ELEMENT;

    public String toString() {
        String result = null;
        switch (this) {
        case NULL_ARGUMENT:
            result = "The passed argument is null";
            break;
        case NULL_IN_COLLECTION:
            result = "Found null value in collection";
            break;
        case NULL_COMPUTED:
            result = "An unexpected null value was received by the caller after a method call";
            break;
        case INVALID_ELEMENT:
            result = "Attempted an operation with an element of a not-allowed type";
            break;
        default:
            result = "";
            break;
        }
        return result;
    }
}
