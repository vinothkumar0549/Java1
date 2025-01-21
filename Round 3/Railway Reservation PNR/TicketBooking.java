public class TicketBooking {

    private char source;
    private char destination;
    private int seats;
    TicketSystem ticketsystem;

    TicketBooking(char source, char destination, int seats) {
        this.source = source;
        this.destination = destination;
        this.seats = seats;
        this.ticketsystem = TicketSystem.getInstance();
    }

    public void bookTicket() {
        if (ticketsystem.checkAvailability(source, destination, seats)) {
            Ticket ticket = new Ticket(source, destination, seats, TicketStatus.Booked);
            int pnr = ticket.getPrn();
            ticketsystem.addToBookedTicket(pnr, ticket);
            System.out.println("Ticket is Booked PNR : " + pnr);
            ticketsystem.decreaseAvailability(source, destination, seats);
        } else {
            if (seats + ticketsystem.getWaitingSeat() > 2) {
                System.out.println("No Tickets Available");
            } else {
                Ticket ticket = new Ticket(source, destination, seats, TicketStatus.Waiting);
                int pnr = ticket.getPrn();
                ticketsystem.addToWaitingTicket(pnr, ticket);
                System.out.println("Ticket is Waiting PNR: " + pnr);
                ticketsystem.setWaitingSeat(ticketsystem.getWaitingSeat() + seats);
            }
        }
    }

    public void execute() {
        this.bookTicket();
    }

}
