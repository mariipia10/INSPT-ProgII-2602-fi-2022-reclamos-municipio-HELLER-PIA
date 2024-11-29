/*
 * 
 * 
 */

package reclamoMuni.exceptions;

/**
 *
 * @author piahe
 */
public class DNIAlreadyExistsException extends RuntimeException {

    public DNIAlreadyExistsException() {
    }

    public DNIAlreadyExistsException(String message) {
        super(message);
    }

    public DNIAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DNIAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}
