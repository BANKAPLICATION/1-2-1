package dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestOneToOne {
    private LocalDateTime dateTime;

    private Long creatorId;

    private Long ownerId;

    private String comment;
}
