package mappers;

import com.rm.toolkit.onetoone.dtos.RequestFeedBack;
import com.rm.toolkit.onetoone.dtos.ResponseFeedBack;
import com.rm.toolkit.onetoone.model.FeedBackEntity;
import lombok.extern.java.Log;
import org.mapstruct.*;

@Log
@Mapper(componentModel = "spring")
public abstract class FeedBackToEntityMapper {

    @Mapping(source = "feedBackEntity.id", target = "id")
    @Mapping(source = "feedBackEntity.creatorId", target = "creatorId")
    @Mapping(source = "feedBackEntity.ownerId", target = "ownerId")
    @Mapping(source = "feedBackEntity.createdDate", target = "createdDate")
    @Mapping(source = "feedBackEntity.updatedDate", target = "updatedDate")
    @Mapping(source = "feedBackEntity.overallPerformance", target = "overallPerformance")
    @Mapping(source = "feedBackEntity.professionalSkills", target = "professionalSkills")
    @Mapping(source = "feedBackEntity.qualityWork", target = "qualityWork")
    @Mapping(source = "feedBackEntity.problemSolvingSkills", target = "problemSolvingSkills")
    @Mapping(source = "feedBackEntity.reliability", target = "reliability")
    @Mapping(source = "feedBackEntity.communicationsSkills", target = "communicationsSkills")
    @Mapping(source = "feedBackEntity.progress", target = "progress")
    @Mapping(source = "feedBackEntity.projectQuality", target = "projectQuality")
    @Mapping(source = "feedBackEntity.goalQuality", target = "goalQuality")
    @Mapping(source = "feedBackEntity.departmentQuality", target = "departmentQuality")
    @Mapping(source = "feedBackEntity.activityParticipation", target = "activityParticipation")
    @Mapping(source = "feedBackEntity.additionalInformation", target = "additionalInformation")
    @Mapping(source = "feedBackEntity.oneToOneMeet.id", target = "oneToOneMeetId")
    public abstract ResponseFeedBack toDto(FeedBackEntity feedBackEntity);

    @Mapping(source = "requestFeedBack.creatorId", target = "creatorId")
    @Mapping(source = "requestFeedBack.ownerId", target = "ownerId")
    @Mapping(source = "requestFeedBack.createdDate", target = "createdDate")
    @Mapping(source = "requestFeedBack.updatedDate", target = "updatedDate")
    @Mapping(source = "requestFeedBack.overallPerformance", target = "overallPerformance")
    @Mapping(source = "requestFeedBack.professionalSkills", target = "professionalSkills")
    @Mapping(source = "requestFeedBack.qualityWork", target = "qualityWork")
    @Mapping(source = "requestFeedBack.problemSolvingSkills", target = "problemSolvingSkills")
    @Mapping(source = "requestFeedBack.reliability", target = "reliability")
    @Mapping(source = "requestFeedBack.communicationsSkills", target = "communicationsSkills")
    @Mapping(source = "requestFeedBack.progress", target = "progress")
    @Mapping(source = "requestFeedBack.projectQuality", target = "projectQuality")
    @Mapping(source = "requestFeedBack.goalQuality", target = "goalQuality")
    @Mapping(source = "requestFeedBack.departmentQuality", target = "departmentQuality")
    @Mapping(source = "requestFeedBack.activityParticipation", target = "activityParticipation")
    @Mapping(source = "requestFeedBack.additionalInformation", target = "additionalInformation")
    @Mapping(source = "requestFeedBack.oneToOneMeetId", target = "oneToOneMeet.id")
    public abstract FeedBackEntity toEntity(RequestFeedBack requestFeedBack);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({@Mapping(target = "id", ignore = true)})
    public abstract FeedBackEntity updateFeedback(
            @MappingTarget FeedBackEntity feedbackEntity, RequestFeedBack feedbackEdit);

}
