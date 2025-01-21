package questions106;

import java.util.ArrayList;
import java.util.List;

public class Q103KadaneAlgoWithoutNegative {
    public static void main(String[] args) {
        // int[] arr = { -2, 7, 5, 14, -1, 3, 2, 9, 7 };
        int[] arr = { -2, 7, 5, -1, 3, 2, 9, -7 };
        int max = 0, currmax = 0;
        List<Integer> maxarr = new ArrayList<>();
        List<Integer> temparr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (max < currmax) {
                    max = currmax;
                    maxarr = new ArrayList<>(temparr);
                }
                currmax = 0;
                temparr.clear();
                continue;
            }
            currmax += arr[i];
            temparr.add(arr[i]);
        }
        if (max > currmax) {
            System.out.println(max);
        } else {
            System.out.println(currmax);
            maxarr = new ArrayList<>(temparr);
        }

        for (int i : maxarr) {
            System.out.print(i + " ");
        }

    }
}
