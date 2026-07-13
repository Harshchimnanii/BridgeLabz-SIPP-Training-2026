import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private final String description;

    protected CourseType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + description + ")";
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-based evaluation");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-based evaluation");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-based evaluation");
    }
}

class Course<T extends CourseType> {
    private final String courseName;
    private final T courseType;
    private final List<String> enrolledStudents = new ArrayList<>();

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public void enrollStudent(String studentName) {
        enrolledStudents.add(studentName);
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    public List<String> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents);
    }
}

public class UniversityCourseManagementSystem {

    public static void displayCourses(List<? extends Course<?>> courses) {
        for (Course<?> course : courses) {
            System.out.println("Course: " + course.getCourseName() + " | Type: " + course.getCourseType());
            System.out.println(" Students: " + course.getEnrolledStudents());
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> algorithms = new Course<>("Algorithms", new ExamCourse());
        algorithms.enrollStudent("Rita");
        algorithms.enrollStudent("Sameer");

        Course<AssignmentCourse> communication = new Course<>("Communication Skills", new AssignmentCourse());
        communication.enrollStudent("Nina");
        communication.enrollStudent("Arjun");

        Course<ResearchCourse> aiResearch = new Course<>("AI Research", new ResearchCourse());
        aiResearch.enrollStudent("Meera");

        List<Course<?>> courses = new ArrayList<>();
        courses.add(algorithms);
        courses.add(communication);
        courses.add(aiResearch);

        displayCourses(courses);
    }
}
