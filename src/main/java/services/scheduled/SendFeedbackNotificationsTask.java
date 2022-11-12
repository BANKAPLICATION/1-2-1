package services.scheduled;

import com.rm.toolkit.onetoone.dtos.UserInfo;
import com.rm.toolkit.onetoone.model.OneToOneMeetEntity;
import com.rm.toolkit.onetoone.repos.OneToOneMeetRepository;
import com.rm.toolkit.onetoone.services.MailSenderService;
import com.rm.toolkit.onetoone.services.NotificationService;
import com.rm.toolkit.onetoone.services.UserService;
import com.rm.toolkit.onetoone.services.scheduled.NotificationMessages.MessageContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SendFeedbackNotificationsTask implements Runnable {

    private final OneToOneMeetRepository oneToOneMeetRepository;
    private final NotificationService notificationService;
    private final UserService userService;
    private final MailSenderService mailSenderService;
    private final MessageContainer messageContainer;

    @Override
    public void run() {
        List<OneToOneMeetEntity> listOneToOne = oneToOneMeetRepository.findAllByFeedBackNull();
        int intervalFeedback = notificationService.getTimeToSetFeedBack();
        for (OneToOneMeetEntity oneToOne : listOneToOne) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long days = ChronoUnit.DAYS.between(oneToOne.getDateTime().toLocalDate(), LocalDateTime.now().toLocalDate());

            UserInfo userInfoForCreator = userService.getUser(oneToOne.getCreatorId());
            UserInfo userInfoForOwner = userService.getUser(oneToOne.getOwnerId());
            UserInfo userInfoForRd = userService.getUser(1L);

            String emailRm = userInfoForCreator.getEmail();
            String emailChief = userInfoForOwner.getChief().getEmail();
            String emailRd = userInfoForRd.getEmail();

            if (days == intervalFeedback) {

                String messageForRm = messageContainer.messageForRm(userInfoForCreator.getName(),
                        userInfoForOwner.getSurname(), userInfoForOwner.getName());
                mailSenderService.sendMail(emailRm, "Напоминание о необходимости оставить отзыв!", messageForRm);

                String messageForChief = messageContainer.messageForChief(userInfoForCreator.getSurname(),
                        userInfoForOwner.getSurname(), userInfoForOwner.getName());
                mailSenderService.sendMail(emailChief, "Напоминание о необходимости оставить отзыв!",
                        messageForChief);
            } else if (days > intervalFeedback) {

                String messageForRm = messageContainer.messageForRmRepeated(userInfoForCreator.getName(),
                        userInfoForOwner.getSurname(), userInfoForOwner.getName());
                mailSenderService.sendMail(emailRm, "Напоминание о необходимости оставить отзыв!", messageForRm);

                String messageForChief = messageContainer.messageForChiefRepeated(userInfoForCreator.getSurname(),
                        userInfoForOwner.getSurname(), userInfoForOwner.getName());
                mailSenderService.sendMail(emailChief, "Напоминание о необходимости оставить отзыв!", messageForChief);

                String messageForRd = messageContainer.messageForRd(userInfoForRd.getName(),
                        userInfoForCreator.getSurname(), userInfoForCreator.getName(), userInfoForOwner.getSurname(),
                        userInfoForOwner.getName());
                mailSenderService.sendMail(emailRd, "Напоминание о необходимости оставить отзыв!", messageForRd);

            }
        }
    }
}