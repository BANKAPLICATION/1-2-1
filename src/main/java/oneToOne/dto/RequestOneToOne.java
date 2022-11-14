package oneToOne.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import oneToOne.model.Status;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class RequestOneToOne {
    private Long id;

    private LocalDateTime dateTime;

    private Long creatorId;

    private Long ownerId;

    private String comment;

    private Status status;
}
