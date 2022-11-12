package dtos;

import com.rm.toolkit.onetoone.model.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseOneToOne {
    private Long id;

    private LocalDateTime dateTime;

    private Long creatorId;

    private String creatorName;

    private String creatorSurname;

    private String creatorEmail;

    private Long ownerId;

    private String ownerName;

    private String ownerSurname;

    private String ownerEmail;

    private String comment;

    private Status status;
}
