package journal.com.journalapp;

public class Users {
    String id;
    String displayName;
    String emailAddress;
    int numberPhone;


    public Users(String id, String displayName, String emailAddress, int numberPhone) {

        this.id=id;
        this.displayName = displayName;
        this.emailAddress = emailAddress;
        this.numberPhone = numberPhone;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

}
