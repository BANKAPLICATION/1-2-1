package services;

import com.rm.toolkit.onetoone.dtos.RequestGoal;
import com.rm.toolkit.onetoone.dtos.RequestSubGoal;
import com.rm.toolkit.onetoone.dtos.ResponseGoal;
import com.rm.toolkit.onetoone.dtos.ResponseSubGoal;

public interface GoalService {
    ResponseGoal createGoal(RequestGoal requestGoal);
    ResponseSubGoal createSubGoal(RequestSubGoal requestSubGoal);
}
