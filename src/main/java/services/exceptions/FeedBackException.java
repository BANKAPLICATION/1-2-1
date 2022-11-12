package services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class FeedBackException extends HttpStatusCodeException {

    public FeedBackException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
