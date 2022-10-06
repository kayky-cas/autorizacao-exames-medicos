package exceptions;

public class UserException extends Exception {
    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
