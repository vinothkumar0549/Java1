package questions106;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class Q73DescendingFrequency {
    public static void main(String[] args) {
        // int arr[] = { 3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5 };
        int arr[] = { 0, -1, 2, 1, 0 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        for (Map.Entry<Integer, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                System.out.print(e.getKey() + " ");
            }
        }

    }
}
