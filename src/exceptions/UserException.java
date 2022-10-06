package exceptions;

public class UserException extends Exception {
    public UserException(String message, String cause) {
        super(message, cause);
    }
}
