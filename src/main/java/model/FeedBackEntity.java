package model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
public class FeedBackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "overall_performance")
    private int overallPerformance;

    @Column(name = "professional_skills")
    private int professionalSkills;

    @Column(name = "quality_work")
    private int qualityWork;

    @Column(name = "problem_solving_skills")
    private int problemSolvingSkills;

    @Column(name = "reliability")
    private int reliability;

    @Column(name = "communications_skills")
    private int communicationsSkills;

    @Column(name = "progress")
    private String progress;

    @Column(name = "project_quality")
    private String projectQuality;

    @Column(name = "goal_quality")
    private String goalQuality;

    @Column(name = "department_quality")
    private String departmentQuality;

    @Column(name = "activity_participation")
    private String activityParticipation;

    @Column(name = "additional_participation")
    private String additionalInformation;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "one_to_one_meet_id", referencedColumnName = "id", nullable = false)
    private OneToOneMeetEntity oneToOneMeet;


    public FeedBackEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getOverallPerformance() {
        return overallPerformance;
    }

    public void setOverallPerformance(int overallPerformance) {
        this.overallPerformance = overallPerformance;
    }

    public int getProfessionalSkills() {
        return professionalSkills;
    }

    public void setProfessionalSkills(int professionalSkills) {
        this.professionalSkills = professionalSkills;
    }

    public int getQualityWork() {
        return qualityWork;
    }

    public void setQualityWork(int qualityWork) {
        this.qualityWork = qualityWork;
    }

    public int getProblemSolvingSkills() {
        return problemSolvingSkills;
    }

    public void setProblemSolvingSkills(int problemSolvingSkills) {
        this.problemSolvingSkills = problemSolvingSkills;
    }

    public int getReliability() {
        return reliability;
    }

    public void setReliability(int reliability) {
        this.reliability = reliability;
    }

    public int getCommunicationsSkills() {
        return communicationsSkills;
    }

    public void setCommunicationsSkills(int communicationsSkills) {
        this.communicationsSkills = communicationsSkills;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getProjectQuality() {
        return projectQuality;
    }

    public void setProjectQuality(String projectQuality) {
        this.projectQuality = projectQuality;
    }

    public String getGoalQuality() {
        return goalQuality;
    }

    public void setGoalQuality(String goalQuality) {
        this.goalQuality = goalQuality;
    }

    public String getDepartmentQuality() {
        return departmentQuality;
    }

    public void setDepartmentQuality(String departmentQuality) {
        this.departmentQuality = departmentQuality;
    }

    public String getActivityParticipation() {
        return activityParticipation;
    }

    public void setActivityParticipation(String activityParticipation) {
        this.activityParticipation = activityParticipation;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }


    public OneToOneMeetEntity getOneToOneMeet() {
        return oneToOneMeet;
    }

    public void setOneToOneMeet(OneToOneMeetEntity oneToOneMeet) {
        this.oneToOneMeet = oneToOneMeet;
    }
}
