import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n;
            while (true) {
                System.out.println(
                        "---Main Menu--- \n 1. Book Ticket\n 2. Cancel Ticket\n 3. Display Comfirmed BerthList\n 4. Display RAC List\n 5. Display Waiting List\n 6. Exit\n");
                System.out.println("Enter the Case: ");
                n = scanner.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("Enter the Name: ");
                        String name = scanner.next();
                        System.out.println("Enter the Age: ");
                        int age = scanner.nextInt();
                        System.out.println("Enter the Berth Preference: ");
                        char preference = scanner.next().charAt(0);
                        Passenger p = new Passenger(name, age, preference);
                        TicketBooking.bookticket(p);
                        break;
                    case 2:
                        System.out.println("Enter the Id to Cancel the Ticket: ");
                        int id = scanner.nextInt();
                        TicketCancel.cancelticket(id);
                        break;
                    case 3:
                        TicketBooking.printconfirmedticket();
                        break;
                    case 4:
                        TicketBooking.printracticket();
                        break;
                    case 5:
                        TicketBooking.printwaitingticket();
                        break;
                    case 6:
                        System.out.println("Exit...");
                        System.exit(0);
                    default:
                        System.out.println("InValid Option...");
                        ;
                }
            }
        }
    }
}