import java.util.Scanner;

public class EmployeeBonus10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 10;
        double[] salary = new double[N];
        double[] years = new double[N];
        double[] bonus = new double[N];
        double[] newSalary = new double[N];

        System.out.println("Enter salary and years of service for 10 employees:");
        for (int i = 0; i < N; i++) {
            System.out.print("Employee " + (i + 1) + " salary: ");
            double s = sc.nextDouble();
            System.out.print("Employee " + (i + 1) + " years of service: ");
            double y = sc.nextDouble();
            if (s <= 0 || y < 0) {
                System.out.println("Invalid input. Salary must be > 0 and years >= 0. Enter again.");
                i--; // repeat this index
                continue;
            }
            salary[i] = s;
            years[i] = y;
        }

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        for (int i = 0; i < N; i++) {
            double pct = (years[i] > 5) ? 0.05 : 0.02;
            bonus[i] = salary[i] * pct;
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("Summary:");
        for (int i = 0; i < N; i++) {
            System.out.printf("Emp %d: old=%.2f years=%.1f bonus=%.2f new=%.2f%n", i + 1, salary[i], years[i], bonus[i], newSalary[i]);
        }
        System.out.printf("Total old salary=%.2f, total bonus=%.2f, total new salary=%.2f%n", totalOldSalary, totalBonus, totalNewSalary);
        sc.close();
    }
}
