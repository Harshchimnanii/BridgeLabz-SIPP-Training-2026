import java.util.HashSet;

public class EventEntryVerificationSystem {

    private final HashSet<String> participants = new HashSet<>();

    public boolean registerParticipant(String email) {
        if (participants.add(email)) {
            System.out.println("Registered: " + email);
            return true;
        }
        System.out.println("Duplicate registration rejected for: " + email);
        return false;
    }

    public void displayParticipants() {
        System.out.println("\nUnique registered participants (" + participants.size() + "):");
        for (String email : participants) {
            System.out.println("- " + email);
        }
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem event = new EventEntryVerificationSystem();

        event.registerParticipant("shardul@example.com");
        event.registerParticipant("nisha@example.com");
        event.registerParticipant("aman@example.com");
        event.registerParticipant("nisha@example.com");
        event.registerParticipant("ravi@example.com");

        event.displayParticipants();
    }
}
