import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Taxi {
    private static int taxicount = 1;
    private int taxiid;
    private char currpoint;
    private double freetime;
    private int totalearning;
    private List<String> trips;

    Taxi() {
        this.taxiid = taxicount++;
        this.currpoint = 'A';
        this.freetime = 6;
        this.totalearning = 0;
        this.trips = new ArrayList<>();
    }

    public char getcurrpoint() {
        return this.currpoint;
    }

    public void setcurrpoint(char point) {
        this.currpoint = point;
    }

    public double getfreetime() {
        return this.freetime;
    }

    public void setfreetime(int time) {
        this.freetime = time;
    }

    public int gettotalearning() {
        return this.totalearning;
    }

    public void settotalearning(int earn) {
        this.totalearning = this.totalearning + earn;
    }

    public void setdetails(char currposition, int earn, double free, String trip) {
        this.currpoint = currposition;
        this.totalearning = this.totalearning + earn;
        this.freetime = free;
        this.trips.add(trip);
    }

    static public List<Taxi> createTaxis(int n) {
        List<Taxi> taxis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Taxi t = new Taxi();
            taxis.add(t);
        }
        System.out.println("tAXI cREATED");
        return taxis;
    }

    static public int bookTaxi(List<Taxi> taxis, int id, char pickup, char drop, double time) {
        List<Taxi> freeTaxi = new ArrayList<>();
        for (Taxi t : taxis) {
            if (t.freetime <= time && Math.abs((t.currpoint - '0') - (pickup - '0')) <= time - t.freetime) {
                freeTaxi.add(t);
            }
        }
        Collections.sort(freeTaxi, (a, b) -> a.totalearning - b.totalearning);

        if (freeTaxi.size() == 0) {
            System.out.println("Sorry! Taxi is not Available");
            return 0;
        }

        int min = 999;
        char currposition = '\0';
        int earn = 0;
        String trip = "";
        double free = 0.0;
        int distance = Math.abs((drop - '0') - (pickup - '0')) * 15;
        Taxi BookedTaxi = null;

        for (Taxi t : freeTaxi) {
            int taxidistance = Math.abs((t.currpoint - '0') - (pickup - '0')) * 15;
            if (taxidistance < min) {
                BookedTaxi = t;
                currposition = drop;
                earn = (distance - 5) * 10 + 100;
                free = time + (distance / 15);
                System.out.println(free + " " + distance);
                trip = "Customer Id " + id + " PickUp " + pickup + " drop " + drop + " PickUp Time: " + time
                        + " Drop Time: " + free + " Amount " + earn;
                min = taxidistance;
            }
        }
        BookedTaxi.setdetails(currposition, earn, free, trip);
        return BookedTaxi.taxiid;
    }

    static public void printTaxiDetails(List<Taxi> taxis) {
        for (Taxi t : taxis) {
            System.out.println("----------------------------------------------------------------------");
            System.out
                    .println("Taxi Id: " + t.taxiid + "\nCurrent Position: " + t.currpoint + "\nFreeTime: " + t.freetime
                            + "\nTotal Earning: " + t.totalearning);

            for (String detail : t.trips) {
                System.out.println(detail);
            }
        }
        System.out.println("---------------------------------------------------------------------");
    }
}
