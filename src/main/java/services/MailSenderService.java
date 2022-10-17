package services;

public interface MailSenderService {
    void sendMail(String emailTo, String subject, String message);
}