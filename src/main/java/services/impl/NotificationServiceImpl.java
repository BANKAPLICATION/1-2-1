package services.impl;

import com.rm.toolkit.onetoone.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private int daysToSetStatus = 1;
    private int daysToSetFeedBack = 1;
    private int dayToCreateOneToOne = 45;

    @Override
    public void setTimeToSetStatus(int days) {
        this.daysToSetStatus = days;
    }

    @Override
    public int getTimeToSetStatus() {
        return this.daysToSetStatus;
    }

    @Override
    public void setTimeToSetFeedBack(int days) {
        this.daysToSetFeedBack = days;
    }

    @Override
    public int getTimeToSetFeedBack() {
        return this.daysToSetFeedBack;
    }

    @Override
    public void setTimeOneToOneMeet(int days) {
        this.dayToCreateOneToOne = days;
    }

    @Override
    public int getTimeToSetMeet() {
        return this.dayToCreateOneToOne;
    }
}
