package questions106;

import java.util.Arrays;

public class Q61OddAscenEvenDescen {
    public static void main(String[] args) {
        int[] arr = { 5, 8, 11, 6, 2, 1, 7 };
        int l = 0, r = arr.length - 1, k = 0;

        while (l < r) {
            while (l < r && arr[l] % 2 != 0) {
                l++;
                k++;
            }
            while (l < r && arr[r] % 2 == 0) {
                r--;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        Arrays.sort(arr, 0, k);
        Arrays.sort(arr, k, arr.length);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
