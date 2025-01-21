package questions20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Q8MergeIntravels {

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18));

        List<Interval> mergeinIntervals = merge(intervals);

        for (Interval interval : mergeinIntervals) {
            System.out.println("[ " + interval.start + " " + interval.end + " ]");
        }

    }

    static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergeintervals = new ArrayList<>();

        Interval currentInterval = intervals.get(0);
        mergeintervals.add(currentInterval);
        for (Interval interval : intervals) {
            if (currentInterval.end >= interval.start) {
                int e = Math.max(currentInterval.end, interval.end);
                currentInterval.end = e;
            } else {
                currentInterval = interval;
                mergeintervals.add(currentInterval);
            }
        }
        return mergeintervals;
    }
}
