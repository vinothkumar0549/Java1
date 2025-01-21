package questions106;

import java.util.TreeMap;
import java.util.Map;

public class Q25FirstLargeFirstSmall {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] arr = { 1, 5, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> first = map.pollFirstEntry();
            System.out.print(first.getKey() + " ");
            if (first.getValue() != 1) {
                map.put(first.getKey(), first.getValue() - 1);
            }
            if (!map.isEmpty()) {
                Map.Entry<Integer, Integer> last = map.pollLastEntry();
                System.out.print(last.getKey() + " ");
                if (last.getValue() != 1) {
                    map.put(last.getKey(), last.getValue() - 1);
                }
            }
        }
    }
}

// package questions106;

// import java.util.TreeSet;

// public class Q25FirstLargeFirstSmall {
// public static void main(String[] args) {
// TreeSet<Integer> set = new TreeSet<>();
// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
// for (int i = 0; i < arr.length; i++) {
// set.add(arr[i]);
// }
// while (!set.isEmpty()) {
// System.out.print(set.pollFirst() + " ");
// if (!set.isEmpty()) {
// System.out.print(set.pollLast() + " ");
// }
// }
// }
// }
