import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SmartCityTrafficMonitoringSystem {

    private final HashMap<String, Integer> roadCounts = new HashMap<>();

    public void addOrUpdateRoadCount(String roadName, int count) {
        roadCounts.put(roadName, roadCounts.getOrDefault(roadName, 0) + count);
    }

    public void displaySortedRoads() {
        TreeMap<String, Integer> sortedRoads = new TreeMap<>(roadCounts);
        System.out.println("\nTraffic report by road:");
        for (Map.Entry<String, Integer> entry : sortedRoads.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vehicles");
        }
        System.out.println("Total roads monitored: " + sortedRoads.size());
    }

    public void displayBusiestRoad() {
        String busiestRoad = null;
        int maxCount = -1;
        for (Map.Entry<String, Integer> entry : roadCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                busiestRoad = entry.getKey();
            }
        }
        if (busiestRoad != null) {
            System.out.println("\nBusiest road: " + busiestRoad + " with " + maxCount + " vehicles.");
        } else {
            System.out.println("\nNo roads are currently monitored.");
        }
    }

    public static void main(String[] args) {
        SmartCityTrafficMonitoringSystem traffic = new SmartCityTrafficMonitoringSystem();

        traffic.addOrUpdateRoadCount("MG Road", 120);
        traffic.addOrUpdateRoadCount("Ring Road", 220);
        traffic.addOrUpdateRoadCount("Highway 7", 350);
        traffic.addOrUpdateRoadCount("MG Road", 80);
        traffic.addOrUpdateRoadCount("City Road", 160);

        traffic.displaySortedRoads();
        traffic.displayBusiestRoad();
    }
}
