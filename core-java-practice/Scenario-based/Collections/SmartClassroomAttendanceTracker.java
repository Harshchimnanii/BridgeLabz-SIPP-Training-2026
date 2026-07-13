import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SmartClassroomAttendanceTracker {

    private final HashMap<String, ArrayList<String>> attendanceBySubject = new HashMap<>();

    public void markAttendance(String subject, String studentName) {
        attendanceBySubject.putIfAbsent(subject, new ArrayList<>());
        ArrayList<String> students = attendanceBySubject.get(subject);
        if (students.contains(studentName)) {
            System.out.println(studentName + " is already marked present in " + subject + ".");
            return;
        }
        students.add(studentName);
        System.out.println("Marked present: " + studentName + " for " + subject + ".");
    }

    public void displayAttendance() {
        System.out.println("\nAttendance by Subject:");
        for (Map.Entry<String, ArrayList<String>> entry : attendanceBySubject.entrySet()) {
            String subject = entry.getKey();
            ArrayList<String> students = entry.getValue();
            System.out.println(subject + " (" + students.size() + " students):");
            for (String student : students) {
                System.out.println(" - " + student);
            }
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();

        tracker.markAttendance("Java", "Riya");
        tracker.markAttendance("Java", "Aman");
        tracker.markAttendance("Python", "Riya");
        tracker.markAttendance("Python", "Nina");
        tracker.markAttendance("Java", "Aman");
        tracker.markAttendance("Data Structures", "Aman");
        tracker.markAttendance("Data Structures", "Riya");

        tracker.displayAttendance();
    }
}
