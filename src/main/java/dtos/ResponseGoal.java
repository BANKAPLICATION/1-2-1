package dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ResponseGoal {

    private Long id;

    private String goalTitle;

    private Date preferableDateToFinishGoal;

    private String comment;

    private Long creatorId;

    private Long ownerId;
}
