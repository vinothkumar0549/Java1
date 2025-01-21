import java.util.List;
import java.util.ArrayList;

public class Lift {

    static List<Lift> liftlist = new ArrayList<>();
    String name;
    int floor;
    int minimum;
    int maximum;
    int capacity;

    Lift(int id, int min, int max, int capacity) {
        this.name = "L" + id;
        this.floor = 0;
        this.minimum = min;
        this.maximum = max;
        this.capacity = capacity;
    }

    static void AssignLift(int start, int end) {
        int min = 99;
        Lift currlift = null;
        for (Lift lift : liftlist) {
            if (!(start >= lift.minimum && start <= lift.maximum && end >= lift.minimum
                    && end <= lift.maximum)) {
                continue;
            }
            if (lift.floor == -1) {
                continue;
            }
            if (Math.abs(start - lift.floor) < min) {
                currlift = lift;
                min = Math.abs(start - lift.floor);
            } else if (Math.abs(start - lift.floor) == min) {
                if (((currlift.floor <= start) && (start <= end)) || ((end <= start) &&
                        (start <= currlift.floor))) {
                    continue;
                } else if (((lift.floor <= start) && (start <= end)) || ((end <= start) &&
                        (start <= lift.floor))) {
                    currlift = lift;
                    min = Math.abs(start - lift.floor);
                }
            }
        }
        if (currlift != null) {
            currlift.floor = end;
            System.out.println(currlift.name + " is Assigned");
        }
    }

    static void printLiftDetails() {
        System.out.println("---------------------------");
        for (Lift lift : liftlist) {
            System.out.print("Lift: " + lift.name);
            System.out.print(" Floor: " + lift.floor);
            System.out.print(" Min: " + lift.minimum);
            System.out.print(" Max: " + lift.maximum);
            System.out.println(" Capacity: " + lift.capacity);

        }
        System.out.println("---------------------------");
    }

    static void markMaintainence(String id) {
        for (Lift lift : liftlist) {
            if ((lift.name).equals(id)) {
                lift.floor = -1;
                break;
            }
        }
        System.out.println("Lift Id " + id + " Under Maintenance");
    }

    static void initializeLift(int id, int min, int max, int capacity) {
        liftlist.add(new Lift(id, min, max, capacity));
    }
}
