package services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StatusException extends ResponseStatusException {
    public StatusException(HttpStatus status, String reason) {
        super(status, reason);
    }
}