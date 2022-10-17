package dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {

    private LocalDateTime timestamp;

    private Integer status;

    private String error;

    private String message;
}