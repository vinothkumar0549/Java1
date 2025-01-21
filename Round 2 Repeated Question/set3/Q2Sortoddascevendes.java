package set3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q2Sortoddascevendes {
    public static void main(String[] args) {
        int[] arr = { 5, 8, 11, 10, 6, 2, 1, 7 };
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int i : arr) {
            if (i % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        Collections.sort(odd);
        Collections.sort(even, Comparator.reverseOrder());

        int k = 0;
        for (int i : odd) {
            arr[k++] = i;
        }
        for (int i : even) {
            arr[k++] = i;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
