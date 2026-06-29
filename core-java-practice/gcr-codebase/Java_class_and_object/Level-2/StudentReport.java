public class StudentReport {
    private String name;
    private int rollNumber;
    private int marks;

    public StudentReport(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        }
        return "F";
    }

    public void displayReport() {
        System.out.println("Student Report:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    public static void main(String[] args) {
        StudentReport student = new StudentReport("Priya", 12, 82);
        student.displayReport();
    }
}
