import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

public class TicketBooking {
    private static int berthLimit = 6 / 3; // Total Tickets divide by 3(u,m,l)
    private static int raclimit = 1;
    private static int waitinglimit = 1;

    private static int upperseatnumber = 1;
    private static int middleseatnumber = 2;
    private static int lowerseatnumber = 3;

    static ArrayList<Passenger> confirmedTickets = new ArrayList<>();

    static ArrayList<Passenger> upperlist = new ArrayList<>();
    static ArrayList<Passenger> middlelist = new ArrayList<>();
    static ArrayList<Passenger> lowerlist = new ArrayList<>();

    static Queue<Passenger> raclist = new LinkedList<>();
    static Queue<Passenger> waitinglist = new LinkedList<>();

    public static void bookticket(Passenger p) {
        if (p == null) {
            return;
        }
        if (upperlist.size() == berthLimit && middlelist.size() == berthLimit && lowerlist.size() == berthLimit) {
            if (raclist.size() < raclimit) {
                System.out.println("Booked in Rac\n The Ticket Id: " + p.getid());
                p.setberth("RAC");
                raclist.add(p);
            } else if (waitinglist.size() < waitinglimit) {
                System.out.println("Booked in Wating\n The Ticket Id: " + p.getid());
                p.setberth("Waiting");
                waitinglist.add(p);
            } else {
                p.setid(p.getid() - 1);
                System.out.println("No Tickets Available");
            }

        } else {
            if (checkavailability(p)) {
                System.out.println("Succes Berth Comfirmed...\n The Ticket Id: " + p.getid());
                confirmedTickets.add(p);
            } else {
                p.setid(p.getid() - 1);
                System.out.println("No Ticket Available with Prefered Berth...");
                checkticketavailability();
            }
        }
    }

    public static boolean checkavailability(Passenger p) {
        Map<Integer, String> cancelticketmap = TicketCancel.getcancelseatandnumber();
        if (!cancelticketmap.isEmpty()) {
            if (reassigncancelticketpreference(p, cancelticketmap)) {
                return true;
            }
        }
        if (p.getpreference() == 'U') {
            if (upperlist.size() < berthLimit) {
                p.setseatnumber(upperseatnumber);
                upperseatnumber += 3;
                p.setberth("Upper Berth");
                upperlist.add(p);
                return true;
            }
        }
        if (p.getpreference() == 'M') {
            if (middlelist.size() < berthLimit) {
                p.setseatnumber(middleseatnumber);
                middleseatnumber += 3;
                p.setberth("Middle Berth");
                middlelist.add(p);
                return true;
            }
        }
        if (p.getpreference() == 'L') {
            if (lowerlist.size() < berthLimit) {
                p.setseatnumber(lowerseatnumber);
                lowerseatnumber += 3;
                p.setberth("Lower Berth");
                lowerlist.add(p);
                return true;
            }
        }
        if (!cancelticketmap.isEmpty()) {
            reassigncancelticket(p, cancelticketmap);
            return true;
        }
        return false;
    }

    public static void checkticketavailability() {
        System.out.println("Availability of Tickets in Berth: ");
        System.out.println("The Upper Berth: " + (berthLimit - upperlist.size()));
        System.out.println("The Middle Berth: " + (berthLimit - middlelist.size()));
        System.out.println("The Lower Berth: " + (berthLimit - lowerlist.size()));
    }

    public static void printconfirmedticket() {
        for (Passenger p : confirmedTickets) {
            System.out.println(p.toString());
        }
    }

    public static void printracticket() {
        for (Passenger p : raclist) {
            System.out.println(p.toString());
        }
    }

    public static void printwaitingticket() {
        for (Passenger p : waitinglist) {
            System.out.println(p.toString());
        }
    }

    public static boolean reassigncancelticketpreference(Passenger p, Map<Integer, String> cancelticketmap) {
        for (Map.Entry<Integer, String> e : cancelticketmap.entrySet()) {
            if (p.getpreference() == 'U' && e.getValue().equals("Upper Berth")) {
                System.out.println(e.getKey());
                p.setseatnumber(e.getKey());
                p.setberth(e.getValue());
                upperlist.add(p);
                confirmedTickets.add(p);
                cancelticketmap.remove(e.getKey());
                return true;
            }
            if (p.getpreference() == 'M' && e.getValue().equals("Middle Berth")) {
                p.setseatnumber(e.getKey());
                p.setberth(e.getValue());
                middlelist.add(p);
                cancelticketmap.remove(e.getKey());
                return true;
            }
            if (p.getpreference() == 'L' && e.getValue().equals("Lower Berth")) {
                p.setseatnumber(e.getKey());
                p.setberth(e.getValue());
                lowerlist.add(p);
                cancelticketmap.remove(e.getKey());
                return true;
            }
        }
        return false;
    }

    public static boolean reassigncancelticket(Passenger p, Map<Integer, String> cancelticetmap) {
        Map.Entry<Integer, String> firstelement = cancelticetmap.entrySet().iterator().next();
        p.setseatnumber(firstelement.getKey());
        p.setberth(firstelement.getValue());
        if (firstelement.getValue().equals("Upper Berth")) {
            upperlist.add(p);
        } else if (firstelement.getValue().equals("Middle Berth")) {
            middlelist.add(p);
        } else if (firstelement.getValue().equals("Lower Berth")) {
            lowerlist.add(p);
        }
        return true;
    }
}
