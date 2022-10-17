package mappers;

import com.rm.toolkit.onetoone.dtos.RequestGoal;
import com.rm.toolkit.onetoone.dtos.ResponseGoal;
import com.rm.toolkit.onetoone.model.GoalEntity;
import lombok.extern.java.Log;
import org.mapstruct.Mapper;

@Log
@Mapper(componentModel = "spring")
public abstract class GoalMapper {

    public abstract ResponseGoal toDto(GoalEntity goal);

    public abstract GoalEntity toEntity(RequestGoal goal);

}
