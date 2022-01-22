public class User {
    private final String phoneNumber;
    private final String email;
    private final String user;

    public User(String phoneNumber, String email, String user) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.user = user;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
}
