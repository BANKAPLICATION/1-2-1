package config;

import com.rm.toolkit.onetoone.dtos.ErrorResponse;
import com.rm.toolkit.onetoone.services.exceptions.OneToOneException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler({OneToOneException.class, FeignException.class})
    public ResponseEntity<Object> handleException(Exception e) {
        ErrorResponse body = new ErrorResponse();
        body.setTimestamp(LocalDateTime.now());
        body.setStatus(HttpStatus.CONFLICT.value());
        body.setError(e.getClass().getSimpleName());
        body.setMessage(e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
}
