import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        final int SIZE = 10;

        double[] salary = new double[SIZE];
        double[] years = new double[SIZE];
        double[] bonus = new double[SIZE];
        double[] newSalary = new double[SIZE];

        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        Scanner sc = new Scanner(System.in);

        // Input with validation
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            salary[i] = sc.nextDouble();

            System.out.print("Enter years of service of employee " + (i + 1) + ": ");
            years[i] = sc.nextDouble();

            if (salary[i] <= 0 || years[i] < 0) {
                System.out.println("Invalid input! Please re-enter.");
                i--; // retry same employee
            }
        }

        // Calculation
        for (int i = 0; i < SIZE; i++) {
            if (years[i] > 5) {
                bonus[i] = 0.05 * salary[i]; // 5%
            } else {
                bonus[i] = 0.02 * salary[i]; // 2%
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Output
        System.out.println("\nEmployee Details:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println("Employee " + (i + 1) +
                    " | Old Salary: " + salary[i] +
                    " | Bonus: " + bonus[i] +
                    " | New Salary: " + newSalary[i]);
        }

        System.out.println("\nTotal Old Salary = " + totalOldSalary);
        System.out.println("Total Bonus = " + totalBonus);
        System.out.println("Total New Salary = " + totalNewSalary);

        sc.close();
    }
}