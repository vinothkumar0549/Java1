public class TicketCanceling {

    int pnr;
    int seats;
    TicketSystem ticketsystem;

    TicketCanceling(int pnr, int seats) {
        this.pnr = pnr;
        this.seats = seats;
        this.ticketsystem = TicketSystem.getInstance();
    }

    public void ticketCancel() {
        Ticket ticket = ticketsystem.getTicket(pnr);
        if (ticket != null) {
            if (ticket.getTicketStatus() == TicketStatus.Booked) {
                char source = ticket.getSource(), destination = ticket.getDestination();
                int bookedseats = ticket.getSeats();
                if (bookedseats > seats) {
                    ticket.setSeats(bookedseats - seats);
                    ticketsystem.addToStorePartialCancel(pnr, seats);
                    ticketsystem.increaseAvailability(source, destination, seats);
                    System.out.println(
                            "The Partial Cancel has Done in Pnr " + pnr + " for Seats " + seats + " in Booked List");
                } else if (bookedseats == seats) {
                    ticketsystem.removeBookedTicket(pnr);
                    ticketsystem.addToCancelTicket(pnr, ticket);
                    ticketsystem.increaseAvailability(source, destination, seats);
                    System.out.println("The Pnr " + pnr + " is Canceled in Booked List");
                } else {
                    System.out.println("Seats Count is Not Match");
                    return;
                }
                ticketsystem.updateWaitingList();
            } else if (ticket.getTicketStatus() == TicketStatus.Waiting) {
                int waitseats = ticket.getSeats();
                if (waitseats > seats) {
                    ticket.setSeats(waitseats - seats);
                    ticketsystem.addToStorePartialCancel(pnr, seats);
                    ticketsystem.setWaitingSeat(ticketsystem.getWaitingSeat() - seats);
                    System.out.println(
                            "The Partial Cancel has Done in Pnr " + pnr + " for Seats " + seats + " in Wating List");
                } else if (waitseats == seats) {
                    ticketsystem.removeWaitingTicket(pnr);
                    ticketsystem.addToCancelTicket(pnr, ticket);
                    ticketsystem.setWaitingSeat(ticketsystem.getWaitingSeat() - seats);
                    System.out.println("The Pnr " + pnr + " is Cancelled in Waiting List");
                } else {
                    System.out.println("Seats Count is Not Match");
                }
            }

        } else {
            System.out.println("Ticket PNR is not Found...");
            return;
        }
    }

    public void execute() {
        this.ticketCancel();
    }

}
