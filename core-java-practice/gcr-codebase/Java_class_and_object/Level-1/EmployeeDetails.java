public class EmployeeDetails {
    private String name;
    private int id;
    private double salary;

    public EmployeeDetails(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        EmployeeDetails employee = new EmployeeDetails("Rahul", 101, 45000.0);
        employee.displayDetails();
    }
}
