import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the No. of Employee: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 1; i <= n; i++) {
                System.out.println("Enter the Name, Age, Desgnition, Department, Manager: ");
                String name = scanner.nextLine();
                int age = scanner.nextInt();
                scanner.nextLine();
                String desgnition = scanner.nextLine();
                String department = scanner.nextLine();
                String manager = scanner.nextLine();
                Employee.initializeEmployee(i, name, age, desgnition, department, manager);
            }
            while (true) {
                System.out.println("-----Main Menu-----");
                System.out.println(
                        "1. Print Employee Details\n2. Seach Employee Detials\n3. Employee under Department\n4. Reporting Tree\n5. Exit");
                System.out.println("Enter the Choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Employee.PrintEmployee();
                        break;
                    case 2:

                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice...");
                        ;
                }
            }
        }
    }
}