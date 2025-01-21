import java.util.Map;
import java.util.HashMap;

public class TicketCancel extends TicketBooking {
    static String berth;
    static int seatnumber;

    static Map<Integer, String> cancelseatandnumber = new HashMap<>();

    public static void cancelticket(int id) {
        for (Passenger p : confirmedTickets) {
            if (p.getid() == id) {
                cancel(p);
                return;
            }
        }
        for (Passenger p : raclist) {
            if (p.getid() == id) {
                cancel(p);
                return;
            }
        }
        for (Passenger p : waitinglist) {
            if (p.getid() == id) {
                cancel(p);
            }
        }
    }

    public static void cancel(Passenger p) {
        if (p != null) {
            if ((p.getberth() == "Upper Berth") || (p.getberth() == "Middle Berth")
                    || (p.getberth() == "Lower Berth")) {
                berth = p.getberth();
                seatnumber = p.getseatnumber();
                cancelseatandnumber.put(seatnumber, berth);
                confirmedTickets.remove(p);
                upperlist.remove(p);
                middlelist.remove(p);
                lowerlist.remove(p);
                TicketBooking.bookticket(raclist.poll());
                TicketBooking.bookticket(waitinglist.poll());
                return;
            } else if (p.getberth() == "RAC") {
                raclist.remove(p);
                TicketBooking.bookticket(waitinglist.poll());
                return;
            } else if (p.getberth() == "Waiting") {
                waitinglist.remove(p);
            }
        }
    }

    public static Map<Integer, String> getcancelseatandnumber() {
        return cancelseatandnumber;
    }
}
