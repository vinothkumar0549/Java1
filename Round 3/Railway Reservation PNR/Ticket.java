public class Ticket {

    private static int pnrgenerator = 1;

    private int pnr = pnrgenerator++;
    private char source;
    private char destination;
    private int seats;
    private TicketStatus ticketstatus;

    Ticket(char source, char destination, int seats, TicketStatus ticketstatus) {
        this.source = source;
        this.destination = destination;
        this.seats = seats;
        this.ticketstatus = ticketstatus;
    }

    public int getPrn() {
        return pnr;
    }

    public char getSource() {
        return source;
    }

    public char getDestination() {
        return destination;
    }

    public int getSeats() {
        return seats;
    }

    public TicketStatus getTicketStatus() {
        return ticketstatus;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setTicketStatus(TicketStatus ticketstatus) {
        this.ticketstatus = ticketstatus;
    }

    public String toString() {
        return "Ticket { Pnr = " + pnr + " Source = " + source + " Destination = " + destination + " Seats = " + seats
                + " TicketStatus = " + ticketstatus + " }";
    }

}
