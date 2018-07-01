package journal.com.journalapp;

public class JournalMessages {
    private String id;
    private String message;
    private String date;

    public JournalMessages() {
    }

    public JournalMessages(String id, String message, String date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}
