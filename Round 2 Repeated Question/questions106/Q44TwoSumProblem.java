package questions106;

import java.util.HashMap;

public class Q44TwoSumProblem {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 3, 5, 6 };
        int target = 6;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(arr[i])) {
                System.out.println(arr[map.get(arr[i])] + " " + arr[i]);
            } else {
                map.put(complement, i);
            }
        }
    }
}
