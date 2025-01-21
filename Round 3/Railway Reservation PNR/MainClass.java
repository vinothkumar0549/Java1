import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n, noseats, pnr;
            char source, destination;
            while (true) {
                System.out.println("-----Main Menu-----");
                System.out.println("1. Ticket Booking\n2. Ticket Cancelling\n3. Print Details\n4. Exit");
                System.out.println("Enter the Choice: ");
                n = scanner.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("Enter the Source: ");
                        source = scanner.next().charAt(0);
                        System.out.println("Enter the Destination: ");
                        destination = scanner.next().charAt(0);
                        System.out.println("Enter the No. of Seats: ");
                        noseats = scanner.nextInt();
                        if (source < destination && source >= 'A' && source <= 'E' && destination >= 'A'
                                && destination <= 'E') {
                            TicketBooking ticketbooking = new TicketBooking(source, destination, noseats);
                            ticketbooking.execute();
                        } else {
                            System.out.println("Invalid Source and Destination...");
                        }
                        break;
                    case 2:
                        System.out.println("Enter the PNR: ");
                        pnr = scanner.nextInt();
                        System.out.println("Enter the No. of Seats: ");
                        noseats = scanner.nextInt();
                        TicketCanceling ticketcanceling = new TicketCanceling(pnr, noseats);
                        ticketcanceling.execute();
                        break;
                    case 3:
                        TicketSystem.getInstance().printDetails();
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