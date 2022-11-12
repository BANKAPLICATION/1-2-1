package dtos;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class RequestFeedBack {

    @NotNull
    private Long creatorId;

    @NotNull
    private Long ownerId;

    @NotNull
    private LocalDateTime createdDate;

    @NotNull
    private LocalDateTime updatedDate;

    @Min(value = 1, message = "Min value is 1")
    @Max(value = 5, message = "Max value is 5")
    @NotNull
    private int overallPerformance;

    @Min(value = 1, message = "Min value is 1")
    @Max(value = 5, message = "Max value is 5")
    @NotNull
    private int professionalSkills;

    @Min(value = 1, message = "Min value is 1")
    @Max(value = 5, message = "Max value is 5")
    @NotNull
    private int qualityWork;

    @Min(value = 1, message = "Min value is 1")
    @Max(value = 5, message = "Max value is 5")
    @NotNull
    private int problemSolvingSkills;

    @Min(value = 1, message = "Min value is 1")
    @Max(value = 5, message = "Max value is 5")
    @NotNull
    private int reliability;

    @Min(value = 1, message = "Min value is 1")
    @Max(value = 5, message = "Max value is 5")
    @NotNull
    private int communicationsSkills;

    @NotNull
    @Pattern(regexp = "[^Ѐ-ӿ]+$", message = "It is allowed to use only Latin letters")
    @Size(min = 1, max = 255)
    private String progress;

    @NotNull
    @Pattern(regexp = "[^Ѐ-ӿ]+$", message = "It is allowed to use only Latin letters")
    @Size(min = 1, max = 255)
    private String projectQuality;

    @NotNull
    @Pattern(regexp = "[^Ѐ-ӿ]+$", message = "It is allowed to use only Latin letters")
    @Size(min = 1, max = 255)
    private String goalQuality;

    @NotNull
    @Pattern(regexp = "[^Ѐ-ӿ]+$", message = "It is allowed to use only Latin letters")
    @Size(min = 1, max = 255)
    private String departmentQuality;

    @NotNull
    @Pattern(regexp = "[^Ѐ-ӿ]+$", message = "It is allowed to use only Latin letters")
    @Size(min = 1, max = 255)
    private String activityParticipation;

    @NotNull
    @Pattern(regexp = "[^Ѐ-ӿ]+$", message = "It is allowed to use only Latin letters")
    @Size(min = 1, max = 255)
    private String additionalInformation;

    @NotNull
    private Long oneToOneMeetId;

}