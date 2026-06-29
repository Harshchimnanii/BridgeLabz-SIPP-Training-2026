import java.io.*;
import java.util.*;

public class EmployeeSkillAssignment {
    public static class Employee implements Serializable {
        private static final long serialVersionUID = 1L;
        String id;
        String name;
        String department;
        double salary;
        int[] skillScores;
        int targetScore;

        Employee(String id, String name, String department, double salary, int[] skillScores, int targetScore) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.skillScores = skillScores;
            this.targetScore = targetScore;
        }

        @Override
        public String toString() {
            return "Employee{id='" + id + "', name='" + name + "', department='" + department + "', salary=" + salary + ", skillScores=" + Arrays.toString(skillScores) + ", targetScore=" + targetScore + '}';
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter employee ID: ");
            String id = scanner.nextLine().trim();
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter department: ");
            String department = scanner.nextLine().trim();
            System.out.print("Enter salary: ");
            double salary = scanner.hasNextDouble() ? scanner.nextDouble() : 0.0;
            scanner.nextLine();

            System.out.print("Enter number of skill scores: ");
            int n = scanner.hasNextInt() ? scanner.nextInt() : 0;
            scanner.nextLine();
            int[] skills = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter skill score " + (i + 1) + ": ");
                skills[i] = scanner.hasNextInt() ? scanner.nextInt() : 0;
                scanner.nextLine();
            }

            System.out.print("Enter target team skill score: ");
            int targetScore = scanner.hasNextInt() ? scanner.nextInt() : 0;

            Employee employee = new Employee(id, name, department, salary, skills, targetScore);
            String fileName = "employee_skill_assignment.dat";
            serializeEmployee(employee, fileName);

            System.out.println("Serialized employee data to " + fileName);
            Employee recovered = deserializeEmployee(fileName);
            System.out.println("Recovered employee information:");
            System.out.println(recovered);

            List<List<Integer>> teams = findTeams(skills, targetScore);
            if (teams.isEmpty()) {
                System.out.println("No project teams found with total skill score " + targetScore);
            } else {
                System.out.println("Teams with total skill score " + targetScore + ":");
                for (List<Integer> team : teams) {
                    System.out.println(team);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void serializeEmployee(Employee employee, String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(employee);
        }
    }

    private static Employee deserializeEmployee(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Employee) in.readObject();
        }
    }

    private static List<List<Integer>> findTeams(int[] skills, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(skills, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] skills, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (remaining < 0) {
            return;
        }
        for (int i = start; i < skills.length; i++) {
            current.add(skills[i]);
            backtrack(skills, remaining - skills[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
