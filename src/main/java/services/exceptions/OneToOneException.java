package services.exceptions;

public class OneToOneException extends RuntimeException {

    public OneToOneException(String message) {
        super(message);
    }
}
