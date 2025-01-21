package questions13;

import java.util.ArrayList;
import java.util.Arrays;

public class Q8CommonMinimum {
    public static void main(String[] args) {
        int[] arr = { 1, 99, 22, 44, 1001 };
        int mindiff = Integer.MAX_VALUE;
        ArrayList<Integer> min = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < mindiff) {
                mindiff = diff;
                min.clear();
                min.add(arr[i]);
                min.add(arr[i + 1]);
            } else if (diff == mindiff) {
                min.add(arr[i]);
                min.add(arr[i + 1]);
            }
        }
        for (int i : min) {
            System.out.print(i + " ");
        }
    }
}
