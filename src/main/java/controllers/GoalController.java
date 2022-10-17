package controllers;

import com.rm.toolkit.onetoone.dtos.RequestGoal;
import com.rm.toolkit.onetoone.dtos.RequestSubGoal;
import com.rm.toolkit.onetoone.dtos.ResponseGoal;
import com.rm.toolkit.onetoone.dtos.ResponseSubGoal;
import com.rm.toolkit.onetoone.services.GoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Log
@RestController
@SecurityRequirement(name = "bearer")
@RequestMapping("/one-to-one/goals")
@RequiredArgsConstructor
public class GoalController {
    private final GoalService goalService;

    @Operation(
            summary = "Create a goal"
    )
    @PostMapping
    @ResponseStatus(CREATED)
    public ResponseGoal createGoal(@RequestBody RequestGoal requestGoal) {
        return goalService.createGoal(requestGoal);
    }

    @Operation(
            summary = "Create a sub goal"
    )
    @PostMapping("/subGoal")
    @ResponseStatus(CREATED)
    public ResponseSubGoal createSubGoal(@RequestBody RequestSubGoal requestSubGoal) {
        return goalService.createSubGoal(requestSubGoal);
    }
}
