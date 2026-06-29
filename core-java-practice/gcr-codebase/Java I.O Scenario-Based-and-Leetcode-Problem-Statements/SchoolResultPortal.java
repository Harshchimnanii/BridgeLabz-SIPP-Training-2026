import java.io.*;
import java.util.*;

public class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = args.length > 0 ? args[0] : "student_results.txt";
        String reportFile = "report_cards.txt";

        try (Scanner scanner = new Scanner(new File(inputFile))) {
            List<String> reportLines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                if (parts.length < 2) {
                    continue;
                }

                String name = parts[0];
                int totalMarks = 0;
                int subjectCount = 0;
                for (int i = 1; i < parts.length; i++) {
                    try {
                        totalMarks += Integer.parseInt(parts[i]);
                        subjectCount++;
                    } catch (NumberFormatException e) {
                        // Skip invalid mark values
                    }
                }

                if (subjectCount == 0) {
                    continue;
                }

                double average = totalMarks / (double) subjectCount;
                reportLines.add("Name: " + name);
                reportLines.add("Marks: " + Arrays.toString(Arrays.copyOfRange(parts, 1, parts.length)));
                reportLines.add(String.format("Average: %.2f", average));
                reportLines.add("------------------------------------");
            }

            if (reportLines.isEmpty()) {
                System.out.println("No valid student result data found in " + inputFile);
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile, true))) {
                writer.write("Report generated on " + new Date());
                writer.newLine();
                for (String reportLine : reportLines) {
                    writer.write(reportLine);
                    writer.newLine();
                }
                writer.newLine();
            }

            System.out.println("Report cards appended to " + reportFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
            System.out.println("Please create a file with student name and marks, for example: Rahul 78 82 91");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the report file: " + e.getMessage());
        }
    }
}
