package set4;

import java.util.ArrayList;

public class Q7SubArraySum {
    public static void main(String[] agrs) {
        int[] arr = { 3, 9, 7, 4, 6, 8 };
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int x = 3;
        for (int i = 0; i < (1 << arr.length); i++) {
            ArrayList<Integer> subarray = new ArrayList<>();
            int sum = 0;
            boolean validset = true;
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) > 0) {
                    if (arr[j] % x == 0) {
                        sum += arr[j];
                        subarray.add(arr[j]);
                    } else {
                        validset = false;
                        break;
                    }
                }
            }
            if (validset && subarray.size() >= 2 && subarray.size() <= x && sum % x == 0) {
                result.add(subarray);
            }
        }
        System.out.println(result.size());
        for (ArrayList<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
