public class MockEmailService implements EmailService {
    private EmailBody lastSentEmail;

    @Override
    public void send(EmailBody emailBody) {
        lastSentEmail = emailBody;
    }

    public EmailBody getLastSentEmail() {
        return lastSentEmail;
    }
}