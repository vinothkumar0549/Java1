import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Count of the Lift: ");
            int liftno = scanner.nextInt();
            for (int i = 1; i <= liftno; i++) {
                System.out.println("Enter the Min Floor, Max Floor and Capacity: ");
                int min = scanner.nextInt();
                int max = scanner.nextInt();
                int capacity = scanner.nextInt();
                Lift.initializeLift(i, min, max, capacity);
            }
            while (true) {
                System.out.println("-----Main Menu-----");
                System.out.println("1. Lift Assign\n2. Lift Details\n3. Maintainence\n4. Exit");
                System.out.println("Enter the Choice: ");
                int n = scanner.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("Enter the Start and End Floor: ");
                        int start = scanner.nextInt();
                        int end = scanner.nextInt();
                        Lift.AssignLift(start, end);
                        break;
                    case 2:
                        Lift.printLiftDetails();
                        break;
                    case 3:
                        System.out.print("Enter the Lift Id: ");
                        scanner.nextLine();
                        String id = scanner.nextLine();
                        Lift.markMaintainence(id);
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice...");
                }
            }
        }
    }
}