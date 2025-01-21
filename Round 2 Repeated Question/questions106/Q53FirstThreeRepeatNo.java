package questions106;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

public class Q53FirstThreeRepeatNo {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3 };
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());

        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        System.out.println(list);
        Iterator<Entry<Integer, Integer>> iter = list.iterator();
        int i = 0;
        while (iter.hasNext() && i < 3) {
            System.out.print(iter.next().getKey() + " ");
            i++;
        }
    }
}
