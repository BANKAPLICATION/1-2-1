package services.impl;

import com.rm.toolkit.onetoone.dtos.RequestGoal;
import com.rm.toolkit.onetoone.dtos.RequestSubGoal;
import com.rm.toolkit.onetoone.dtos.ResponseGoal;
import com.rm.toolkit.onetoone.dtos.ResponseSubGoal;
import com.rm.toolkit.onetoone.mappers.GoalMapper;
import com.rm.toolkit.onetoone.mappers.SubGoalMapper;
import com.rm.toolkit.onetoone.model.GoalEntity;
import com.rm.toolkit.onetoone.model.SubGoalEntity;
import com.rm.toolkit.onetoone.repos.GoalRepository;
import com.rm.toolkit.onetoone.repos.SubGoalRepository;
import com.rm.toolkit.onetoone.services.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    private final SubGoalRepository subGoalRepository;

    private final GoalMapper goalMapper;

    private final SubGoalMapper subGoalMapper;

    @Override
    public ResponseGoal createGoal(RequestGoal requestGoal) {
        GoalEntity goalEntity = goalMapper.toEntity(requestGoal);
        return goalMapper.toDto(goalRepository.save(goalEntity));
    }

    @Override
    public ResponseSubGoal createSubGoal(RequestSubGoal requestSubGoal) {
        SubGoalEntity subGoalEntity = subGoalMapper.toEntity(requestSubGoal);
        subGoalEntity.setGoalEntity(goalRepository.getById(requestSubGoal.getGoalId()));
        ResponseSubGoal responseSubGoal = subGoalMapper.toDto(subGoalRepository.save(subGoalEntity));
        responseSubGoal.setGoalId(requestSubGoal.getGoalId());
        return responseSubGoal;
    }




    public String getWithoutVowels(String str) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'E' || str.charAt(i) == 'e' || str.charAt(i) == 'Y'
                    || str.charAt(i) == 'y' || str.charAt(i) == 'U' || str.charAt(i) == 'u'
                    || str.charAt(i) == 'I' || str.charAt(i) == 'i' || str.charAt(i) == 'O'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'A' || str.charAt(i) == 'a') {
                continue;
            }
            res.append(str.charAt(i));
        }
        return res.toString();
    }

}
