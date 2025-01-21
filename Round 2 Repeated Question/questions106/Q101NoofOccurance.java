package questions106;

import java.util.HashMap; // uses LinkedHashMap for the Insertion Order Maintain
import java.util.Map;

public class Q101NoofOccurance {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 6, 1, 6, 2 };

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
