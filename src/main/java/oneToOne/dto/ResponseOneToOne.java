package oneToOne.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import oneToOne.model.Status;

import java.time.LocalDateTime;

@Getter
@Builder
@Setter
public class ResponseOneToOne {
    private Long id;

    private LocalDateTime dateTime;

    private Long creatorId;

    private Long ownerId;

    private String comment;

    private Status status;
}
