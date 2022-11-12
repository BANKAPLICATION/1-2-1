package dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseFeedBack {

    private Long id;

    private Long creatorId;

    private Long ownerId;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private int overallPerformance;

    private int professionalSkills;

    private int qualityWork;

    private int problemSolvingSkills;

    private int reliability;

    private int communicationsSkills;

    private String progress;

    private String projectQuality;

    private String goalQuality;

    private String departmentQuality;

    private String activityParticipation;

    private String additionalInformation;

    private Long oneToOneMeetId;


    /*

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ResponseOneToOne responseOneToOne;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OneToOneMeetEntity oneToOneMeet;
    */

    //private Long oneToOneMeetId;
}