package questions106;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q26DesendingOrderFactors {
    public static void main(String[] args) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int[] arr = { 4, 2, 3, 12, 8 };
        for (int i : arr) {
            int factor = 0;
            for (int k = 1; k <= Math.sqrt(i); k++) {
                if (i % k == 0) {
                    factor++;
                }
                if (k != i / k) {
                    factor++;
                }
            }
            if (map.putIfAbsent(factor, new ArrayList<>(Arrays.asList(i))) != null) {
                ArrayList<Integer> list = map.get(factor);
                list.add(i);
            }
        }
        System.out.println(map);
        for (ArrayList<Integer> list : map.descendingMap().values()) {
            Collections.sort(list, Collections.reverseOrder());
            for (int i : list) {
                System.out.print(i + " ");
            }
        }
    }
}
