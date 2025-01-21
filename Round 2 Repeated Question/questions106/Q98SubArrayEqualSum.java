package questions106;

import java.util.ArrayList;

public class Q98SubArrayEqualSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] arr = { 8, 3, 4, 7, 9 };
        int val = 7;
        for (int i = 0; i < (1 << arr.length); i++) {
            int sum = 0;
            ArrayList<Integer> subarrary = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += arr[j];
                    subarrary.add(arr[j]);
                }
            }
            if (sum == val) {
                result.add(subarrary);
            }
        }

        for (ArrayList<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.err.println();
        }
    }
}
