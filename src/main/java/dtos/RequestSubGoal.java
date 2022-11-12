package dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RequestSubGoal {

    private String goalTitle;

    private Date preferableDateToFinishGoal;

    private Long goalId;

}
