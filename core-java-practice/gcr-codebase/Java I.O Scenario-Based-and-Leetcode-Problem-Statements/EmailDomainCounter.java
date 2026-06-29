import java.io.*;
import java.util.*;

public class EmailDomainCounter {
    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "emails.txt";
        Map<String, Integer> domainCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String email;
            while ((email = reader.readLine()) != null) {
                email = email.trim();
                if (email.isEmpty() || !email.contains("@")) {
                    continue;
                }
                String domain = email.substring(email.indexOf('@') + 1).toLowerCase();
                domainCounts.put(domain, domainCounts.getOrDefault(domain, 0) + 1);
            }

            if (domainCounts.isEmpty()) {
                System.out.println("No valid email entries found in " + fileName);
                return;
            }

            for (Map.Entry<String, Integer> entry : domainCounts.entrySet()) {
                System.out.println(entry.getKey() + " users = " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Email file not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading email file: " + e.getMessage());
        }
    }
}
