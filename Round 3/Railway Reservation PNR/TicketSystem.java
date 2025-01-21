import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Arrays;

public class TicketSystem {

    private Map<Integer, Ticket> bookedticket = new HashMap<>();
    private ConcurrentHashMap<Integer, Ticket> waitingticket = new ConcurrentHashMap<>();
    private Map<Integer, Ticket> cancelticket = new HashMap<>();
    private Map<Integer, Integer> storepartialcancel = new HashMap<>();

    private int[] seatavailable = new int[5];

    private int waitingseat = 0;

    private static TicketSystem ticketsysteminstance = null;

    TicketSystem() {
        Arrays.fill(seatavailable, 8);
    }

    // singleton class -- only one instance
    public static TicketSystem getInstance() {
        if (ticketsysteminstance == null) {
            ticketsysteminstance = new TicketSystem();
        }
        return ticketsysteminstance;
    }

    public int getWaitingSeat() {
        return waitingseat;
    }

    public void setWaitingSeat(int waitingseat) {
        this.waitingseat = waitingseat;
    }

    public boolean checkAvailability(char source, char destination, int seats) {
        for (int i = source - 'A'; i < destination - 'A'; i++) {
            if (seatavailable[i] < seats) {
                return false;
            }
        }
        return true;
    }

    public void addToBookedTicket(int pnr, Ticket ticket) {
        bookedticket.put(pnr, ticket);
    }

    public void decreaseAvailability(char source, char destination, int seats) {
        for (int i = source - 'A'; i < destination - 'A'; i++) {
            seatavailable[i] -= seats;
        }
    }

    public void addToWaitingTicket(int pnr, Ticket ticket) {
        waitingticket.put(pnr, ticket);
    }

    public Ticket getTicket(int pnr) {
        Ticket ticket = bookedticket.get(pnr);
        return (ticket != null) ? ticket : waitingticket.get(pnr);
    }

    public void addToStorePartialCancel(int pnr, int seats) {
        storepartialcancel.put(pnr, storepartialcancel.getOrDefault(pnr, 0) + seats);
    }

    public void increaseAvailability(char source, char destination, int seats) {
        for (int i = source - 'A'; i < destination - 'A'; i++) {
            seatavailable[i] += seats;
        }
    }

    public void removeBookedTicket(int pnr) {
        bookedticket.remove(pnr);
    }

    public void addToCancelTicket(int pnr, Ticket ticket) {
        Integer partial = storepartialcancel.get(pnr);
        int partialcancel = (partial != null) ? partial : 0;
        storepartialcancel.remove(pnr);
        ticket.setTicketStatus((ticket.getTicketStatus() == TicketStatus.Booked) ? TicketStatus.Canceled
                : TicketStatus.WaitingCanceled);
        ticket.setSeats(ticket.getSeats() + partialcancel);
        cancelticket.put(pnr, ticket);
    }

    public void removeWaitingTicket(int pnr) {
        waitingticket.remove(pnr);
    }

    public void updateWaitingList() {
        char source, destination;
        int pnr, seats;
        for (Ticket ticket : waitingticket.values()) {
            source = ticket.getSource();
            destination = ticket.getDestination();
            seats = ticket.getSeats();
            pnr = ticket.getPrn();
            if (checkAvailability(source, destination, seats)) {
                ticket.setTicketStatus(TicketStatus.Booked);
                decreaseAvailability(source, destination, seats);
                addToBookedTicket(pnr, ticket);
                waitingseat -= seats;
                waitingticket.remove(pnr);
            }
        }
    }

    public void printDetails() {
        System.out.println("Chart Detials");

        System.out.println("Booked Ticket: ");
        for (Ticket ticket : bookedticket.values()) {
            System.out.println(ticket.toString());
        }

        System.out.println("Waiting Ticket: ");
        for (Ticket ticket : waitingticket.values()) {
            System.out.println(ticket.toString());
        }

        System.out.println("Canceled Ticket: ");
        for (Ticket ticket : cancelticket.values()) {
            System.out.println(ticket.toString());
        }

        System.out.println("Partial Cancellation: ");
        for (Map.Entry<Integer, Integer> partialcancel : storepartialcancel.entrySet()) {
            System.out
                    .println("Pnr: " + partialcancel.getKey() + " Partial Canceled Seats: " + partialcancel.getValue());
        }

        System.out.println("Waiting Seat: " + waitingseat);

        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");
        for (int i = 0; i < seatavailable.length; i++) {
            System.out.print((char) ('A' + i));
            for (int j = 0; j < 8 - seatavailable[i]; j++) {
                System.out.print("\t*");
            }
            System.out.println();
        }
    }

}
