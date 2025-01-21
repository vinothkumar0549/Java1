import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        int bookid = 1;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the No. of Delivery Executives: ");
            int n = scanner.nextInt();
            DeliveryExecutive.initialize(n);
            while (true) {
                System.out.println("-----Main Menu-----");
                System.out.println("1. Book Delivery\n 2. Print Delivery Details\n 3. Exit");
                System.out.println("Enter the Choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the Restartaunt: ");
                        char restartaunt = scanner.next().charAt(0);
                        System.out.println("Enter the Destination: ");
                        char destination = scanner.next().charAt(0);
                        System.out.println("Enter the Time: ");
                        double time = scanner.nextDouble();
                        int order = DeliveryExecutive.bookDevliery(bookid, restartaunt, destination, time);
                        if (order == bookid) {
                            bookid++;
                        } else if (order == -1) {
                            System.out.println("Not Alloted");
                        }
                        break;
                    case 2:
                        DeliveryExecutive.printDetails();
                        break;
                    case 3:
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice...");
                        ;
                }
            }
        }
    }
}