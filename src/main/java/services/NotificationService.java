package services;

public interface NotificationService {
    void setTimeOneToOneMeet(int days);

    int getTimeToSetMeet();

    void setTimeToSetFeedBack(int days);

    int getTimeToSetFeedBack();

    void setTimeToSetStatus(int days);

    int getTimeToSetStatus();
}
