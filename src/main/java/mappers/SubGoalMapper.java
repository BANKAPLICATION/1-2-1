package mappers;

import com.rm.toolkit.onetoone.dtos.RequestSubGoal;
import com.rm.toolkit.onetoone.dtos.ResponseSubGoal;
import com.rm.toolkit.onetoone.model.SubGoalEntity;
import lombok.extern.java.Log;
import org.mapstruct.Mapper;

@Log
@Mapper(componentModel = "spring")
public abstract class SubGoalMapper {

    public abstract ResponseSubGoal toDto(SubGoalEntity subGoal);

    public abstract SubGoalEntity toEntity(RequestSubGoal subGoal);

}
