package questions106;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;

public class Q75SeconFreqNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3, 1, 2, 4 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> freq = new ArrayList<>(map.entrySet());

        Collections.sort(freq, (a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println(freq.get(1).getKey());
        System.err.println(freq);
    }
}
