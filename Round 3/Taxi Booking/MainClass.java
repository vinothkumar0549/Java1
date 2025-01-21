import java.util.List;
import java.util.Scanner;

public class MainClass {
    static int customerid = 1;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Taxi> taxis = Taxi.createTaxis(4);
            while (true) {
                System.out.println("-----Main Menu-----");
                System.out.println("1. Taxi Booking\n2. Show Taxi Details and Taxi Customer Details\n3. Exit");
                System.out.println("Enter the Option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the PickUp Point: ");
                        char pickup = scanner.next().charAt(0);
                        System.out.println("Enter the Drop Point: ");
                        char drop = scanner.next().charAt(0);
                        System.out.println("Enter the PickUp Time: ");
                        double time = scanner.nextDouble();
                        if (pickup < 'A' || pickup > 'F' || drop < 'A' || drop > 'F') {
                            System.out.println("Enter the Valid Point (A B C D E F)");
                            break;
                        }
                        if (pickup == drop) {
                            System.out.println("Both PickUp and drop are Same...");
                            break;
                        }
                        int taxi = Taxi.bookTaxi(taxis, customerid, pickup, drop, time);
                        if (taxi > 0) {
                            System.out.println("Taxi Booked Successfully...\n Taxi Id: " + taxi);
                            customerid++;
                        }
                        break;
                    case 2:
                        Taxi.printTaxiDetails(taxis);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Enter the Valid Option...");
                        ;
                }

            }
        }
    }

}