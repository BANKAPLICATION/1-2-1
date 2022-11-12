package controllers;

import com.rm.toolkit.onetoone.dtos.RequestOneToOne;
import com.rm.toolkit.onetoone.dtos.ResponseOneToOne;
import com.rm.toolkit.onetoone.dtos.Statistics;
import com.rm.toolkit.onetoone.model.Status;
import com.rm.toolkit.onetoone.repos.OneToOneMeetRepository;
import com.rm.toolkit.onetoone.services.NotificationService;
import com.rm.toolkit.onetoone.services.exceptions.IntervalException;
import com.rm.toolkit.onetoone.services.impl.OneToOneMeetServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Log
@RestController
@SecurityRequirement(name = "bearer")
@RequestMapping("/one-to-one")
@RequiredArgsConstructor
@Validated
@Tag(name = "One to one", description = "Ability to create one to one meet")
public class OneToOneController {
    private final OneToOneMeetServiceImpl oneToOneMeetService;
    private final NotificationService notificationService;
    private final OneToOneMeetRepository oneToOneMeetRepository;

    @Operation(
            summary = "Set interval between appointments (default 45 days)",
            description = "You can set any interval between meetings. The interval is set in days. " +
                    "From this interval, the notification will be calculated (the notification is sent 7, 3, 1 days before " +
                    "meeting")
    @PutMapping("/reminder-between-meet")
    public void changeReminderBetweenMeet(@Min(10) @Max(99) @RequestParam("days") int days) throws IntervalException {
        notificationService.setTimeOneToOneMeet(days);
    }

    @Operation(
            summary = "Get the interval between meetings"
    )
    @GetMapping("/interval-meet")
    @ResponseStatus(HttpStatus.OK)
    public int getIntervalBetweenMeet() {
        return notificationService.getTimeToSetMeet();
    }

    @Operation(
            summary = "Set the notification interval about the need to leave feedback (default 1 day).",
            description = "You can set any interval for notification about the need to leave feedback. The interval is set in days.")
    @PutMapping("/reminder-about-feedback")
    public void changeReminderAboutFeedback(@Min(1) @Max(9) @RequestParam("days") int days) throws IntervalException {
        notificationService.setTimeToSetFeedBack(days);
    }

    @Operation(
            summary = "Get the interval between feedbacks"
    )
    @GetMapping("/interval-feedback")
    @ResponseStatus(HttpStatus.OK)
    public int getIntervalBetweenFeedback() {
        return notificationService.getTimeToSetFeedBack();
    }

    @Operation(
            summary = "Set the notification interval about the need to leave status (Completed) (default 1 day).",
            description = "You can set any interval for notification about the need to leave stasus (Completed). The interval is set in days.")
    @PutMapping("/time-to-set-status")
    public void changeTimeToSetStatus(@Min(1) @Max(9) @RequestParam("days") int days) {
        notificationService.setTimeToSetStatus(days);
    }

    @Operation(
            summary = "Get the interval between feedbacks"
    )
    @GetMapping("/time-to-set-status")
    public int getTimeToSetStatus() {
        return notificationService.getTimeToSetStatus();
    }

    @Operation(
            summary = "Create one to one"
    )
    @PostMapping()
    public ResponseEntity<ResponseOneToOne> createOneToOne(@RequestBody RequestOneToOne requestOneToOne) {
        return ResponseEntity.status(HttpStatus.CREATED).body(oneToOneMeetService.create(requestOneToOne));
    }

    @Operation(
            summary = "Get statistics about one-to-one"
    )
    @GetMapping("/statistics/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Statistics getOnoToOnoStatistics(@PathVariable("id") Long userId) {
        return oneToOneMeetService.getStatistics(userId);
    }

    @PatchMapping("/{one-to-one-id}/set-status")
    @ResponseStatus(HttpStatus.OK)
    public void setStatus(
            @PathVariable("one-to-one-id") long id,
            @RequestParam("status") Status status) {
        oneToOneMeetService.setStatus(id, status);

    }

    @Operation(
            summary = "Delete one to one"
    )
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneToOne(@PathVariable("id") Long id) {
        oneToOneMeetService.delete(id);
    }

    @GetMapping("/by-owner")
    public List<ResponseOneToOne> getOneToOnePageByOwnerId(
            @RequestParam("page") int page,
            @RequestParam("count") int count,
            @RequestParam("user-id") Long userId,
            @RequestParam("status") Status status) {
        return oneToOneMeetService.getOneToOnePageByOwnerId(page, count, status, userId);
    }

    @GetMapping("/by-creator")
    public List<ResponseOneToOne> getOneToOnePageByCreatorId(
            @RequestParam("page") int page,
            @RequestParam("count") int count,
            @RequestParam("user-id") Long userId,
            @RequestParam("status") Status status) {
        return oneToOneMeetService.getOneToOnePageByCreatorId(page, count, status, userId);
    }
}