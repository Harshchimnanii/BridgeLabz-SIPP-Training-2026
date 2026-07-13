import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Astronaut {
    String astronautId;
    String name;
    String specialization;

    Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }
}

public class SpaceMissionCrewManagementSystem {

    private final HashMap<String, ArrayList<Astronaut>> missionCrews = new HashMap<>();
    private final HashMap<String, HashSet<String>> missionCrewMembers = new HashMap<>();

    public void addMission(String missionName) {
        missionCrews.putIfAbsent(missionName, new ArrayList<>());
        missionCrewMembers.putIfAbsent(missionName, new HashSet<>());
    }

    public boolean assignAstronaut(String missionName, Astronaut astronaut) {
        missionCrews.putIfAbsent(missionName, new ArrayList<>());
        missionCrewMembers.putIfAbsent(missionName, new HashSet<>());

        HashSet<String> assignedIds = missionCrewMembers.get(missionName);
        if (assignedIds.contains(astronaut.astronautId)) {
            System.out.println("Astronaut " + astronaut.name + " is already assigned to " + missionName + ".");
            return false;
        }

        missionCrews.get(missionName).add(astronaut);
        assignedIds.add(astronaut.astronautId);
        return true;
    }

    public void displayMissionDetails() {
        System.out.println("\nMission crew details:");
        for (Map.Entry<String, ArrayList<Astronaut>> entry : missionCrews.entrySet()) {
            System.out.println("Mission: " + entry.getKey());
            List<Astronaut> crew = entry.getValue();
            System.out.println("Total astronauts: " + crew.size());
            for (Astronaut astronaut : crew) {
                System.out.println(" - " + astronaut.astronautId + ", " + astronaut.name + ", " + astronaut.specialization);
            }
        }
    }

    public static void main(String[] args) {
        SpaceMissionCrewManagementSystem system = new SpaceMissionCrewManagementSystem();

        system.addMission("Lunar Explorer");
        system.addMission("Mars Surveyor");

        system.assignAstronaut("Lunar Explorer", new Astronaut("AST001", "Meera", "Navigation"));
        system.assignAstronaut("Lunar Explorer", new Astronaut("AST002", "Rakesh", "Engineering"));
        system.assignAstronaut("Lunar Explorer", new Astronaut("AST001", "Meera", "Navigation"));
        system.assignAstronaut("Mars Surveyor", new Astronaut("AST003", "Priya", "Biology"));
        system.assignAstronaut("Mars Surveyor", new Astronaut("AST004", "Amit", "Communications"));

        system.displayMissionDetails();
    }
}
