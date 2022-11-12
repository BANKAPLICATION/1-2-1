package services.scheduled.NotificationMessages;

public interface MessageContainer {

    String messageForRm(String createrName, String ownerSurname, String ownerName);

    String messageForChief(String createrSurname, String ownerSurname, String ownerName);

    String messageForRmRepeated(String createrName, String ownerSurname, String ownerName);

    String messageForChiefRepeated(String createrSurname, String ownerSurname, String ownerName);

    String messageForRd(String rdName, String createrSurname, String createrName, String ownerSurname, String ownerName);

}
