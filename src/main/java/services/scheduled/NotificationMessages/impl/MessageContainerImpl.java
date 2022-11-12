package services.scheduled.NotificationMessages.impl;

import com.rm.toolkit.onetoone.services.scheduled.NotificationMessages.MessageContainer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageContainerImpl implements MessageContainer {
    @Override
    public String messageForRm(String createrName, String ownerSurname, String ownerName) {

        String message = "Добрый день, " + createrName + "!\n" + "Вами не был оставлен фидбек подопечному " +
                ownerSurname + " " + ownerName + " после проведенного 1-2-1.!\n" +
                "В течение 24 часов добавьте фидбеку сотруднику в его личной карточке.\nС уважением, компания Андерсен.";
        return message;
    }

    @Override
    public String messageForChief(String createrSurname, String ownerSurname, String ownerName) {
        String message = "Добрый день!\nРесурсным менеджером " + createrSurname + " не оставлен фидбек подопечному " +
                ownerSurname + " " + ownerName + "!\nС уважением, компания Андерсен.";
        return message;
    }

    @Override
    public String messageForRmRepeated(String createrName, String ownerSurname, String ownerName) {
        String message = "Добрый день, " + createrName + "!\nПовторно уведомляем Вас о том, что Вами не был оставлен фидбек подопечному "+
                ownerSurname + " " + ownerName + " после проведенного 1-2-1.\nС уважением, компания Андерсен";
        return message;
    }

    @Override
    public String messageForChiefRepeated(String createrSurname, String ownerSurname, String ownerName) {
        String message = "Добрый день!\nПосле получения уведомления о не оставленном фидбеке Вашим ресурсным менеджером " +
                createrSurname + " не добавлен фидбек подопечному " + ownerSurname + " " + ownerName +
                " после проведенного 1-2-1.\nС уважением, компания Андерсен";
        return message;
    }

    @Override
    public String messageForRd(String rdName, String createrSurname, String createrName, String ownerSurname, String ownerName) {
        String message = "Добрый день, " + rdName + "!\nРесурсным менеджером " + createrSurname + " " + createrName +
                " после уведомлений и проведенного 1-2-1 не добавлен фидбек подопечному " +
                ownerSurname + " " + ownerName + "!\nС уважением, компания Андерсен.";
        return message;
    }
}
