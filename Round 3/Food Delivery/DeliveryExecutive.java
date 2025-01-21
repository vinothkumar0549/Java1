import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;;

public class DeliveryExecutive {

    static List<DeliveryExecutive> DElist = new ArrayList<>();
    static LinkedHashMap<Integer, String> DeliveryHistory = new LinkedHashMap<>();
    String id;
    double free;
    double start;
    int currpoint;
    int earnings;
    int commission;
    int totaldeliver;
    int currbookid;
    String TotalCharges;

    DeliveryExecutive(int id) {
        this.id = "DE" + id;
        this.free = 0.0;
        this.start = 0.0;
        this.currpoint = '\0';
        this.earnings = 0;
        this.commission = 0;
        this.totaldeliver = 0;
        this.TotalCharges = this.id + " 0 0 0";
    }

    static int bookDevliery(int bookid, char restartaunt, char destination, double time) {
        boolean order = false;
        System.out.println("DE   DC");
        for (DeliveryExecutive executive : DElist) {
            System.out.println(executive.id + "  " + executive.earnings);
        }
        DeliveryExecutive currexecutive = null;
        double currfree = 0.0;
        double currstart = 0.0;
        char currposition = '\0';
        int currearn = 0;
        int currcommission = 0;
        int minimumearning = Integer.MAX_VALUE;
        for (DeliveryExecutive executive : DElist) {
            if (executive.earnings <= minimumearning) {
                int initialtotalminutes = (((int) executive.start) * 60)
                        + (int) ((executive.start - ((int) executive.start)) * 100);
                int currtotalminutes = (((int) time) * 60) + (int) ((time - (int) time) * 100);
                if (Math.abs(currtotalminutes
                        - initialtotalminutes) >= 0 && Math.abs(
                                currtotalminutes -
                                        initialtotalminutes) <= 15
                        && executive.totaldeliver < 5
                        && destination == executive.currpoint) {
                    executive.earnings += 5;
                    executive.totaldeliver++;
                    DeliveryHistory
                            .put(executive.currbookid,
                                    executive.currbookid + " " + executive.id + " " + restartaunt + " " + destination
                                            + " "
                                            + executive.totaldeliver + " " + executive.start + " " + executive.free
                                            + " "
                                            + executive.earnings);
                    executive.TotalCharges = (executive.id + " " + executive.commission + " " + executive.earnings + " "
                            + (executive.commission + executive.earnings));
                    System.out.println("Allotted Delivery Executive: " + executive.id);
                    return executive.currbookid;

                } else {
                    if (executive.earnings == minimumearning) {
                        continue;
                    }
                    int initialhour = (int) time;
                    int totalfreemin = ((int) ((time - initialhour) * 100)) + 45;
                    double freehour = initialhour + (totalfreemin / 60);
                    double freemin = (totalfreemin % 60) / 100.0;

                    currfree = freehour + freemin;

                    int totalstartmin = ((int) ((time - initialhour) * 100)) + 15;
                    double starthour = initialhour + (totalstartmin / 60);
                    double startmin = (totalstartmin % 60) / 100.00;

                    currstart = starthour + startmin;

                    currposition = destination;
                    currearn = executive.earnings + 50;
                    currcommission = executive.commission + 10;
                    currexecutive = executive;

                }
                minimumearning = executive.earnings;
            }
        }
        if (currexecutive != null) {
            currexecutive.currbookid = bookid;
            currexecutive.free = currfree;
            currexecutive.start = currstart;
            currexecutive.currpoint = currposition;
            currexecutive.earnings = currearn;
            currexecutive.commission = currcommission;
            currexecutive.totaldeliver++;
            DeliveryHistory
                    .put(bookid, bookid + " " + currexecutive.id + " " + restartaunt + " " + destination + " "
                            + currexecutive.totaldeliver + " " + currexecutive.start + " " + currexecutive.free + " "
                            + currexecutive.earnings);
            currexecutive.TotalCharges = (currexecutive.id + " " + currexecutive.commission + " "
                    + currexecutive.earnings + " "
                    + (currexecutive.commission + currexecutive.earnings));
            order = true;
        }
        if (order) {
            System.out.println("Allotted Delivery Executive: " + currexecutive.id);
            return bookid;
        }
        System.out.println("Not Delivery Executed Allotted");
        return -1;
    }

    static void printDetails() {
        for (Map.Entry<Integer, String> e : DeliveryHistory.entrySet()) {
            System.out.println(e.getValue());
        }
        for (DeliveryExecutive de : DElist) {
            System.out.println(de.TotalCharges);
        }
    }

    static void initialize(int n) {
        for (int i = 1; i <= n; i++) {
            DElist.add(new DeliveryExecutive(i));
        }
    }
}
