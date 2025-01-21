package questions106;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q102MinimumGreaterNO {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 7, -1, 8, 5, 11 };
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int temp = arr[j] - arr[i];
                if (arr[j] > arr[i]) {
                    if (map.putIfAbsent(arr[i], temp) == null) {
                        continue;
                    } else {
                        if (map.get(arr[i]) > temp) {
                            map.put(arr[i], temp);
                        }
                    }
                }
            }
            map.putIfAbsent(arr[i], 0); // if want the largest number as 0 then a assign -arr[i]
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + (e.getKey() + e.getValue()));
        }
    }
}
