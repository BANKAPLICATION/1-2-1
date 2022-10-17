package services.scheduled;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Setter
@Getter
@RequiredArgsConstructor
@Component
public class ScheduledService {

    private final SendFeedbackNotificationsTask sendFeedbackNotificationsTask;

    @Scheduled(cron = "0 6 * * * ?")
    public void remaindAboutFeedback(){
        sendFeedbackNotificationsTask.run();
    }
}