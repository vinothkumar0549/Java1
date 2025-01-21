package questions106;

import java.util.Arrays;

public class Q15BikeProblem {
    public static void main(String[] args) {
        int[] arr = { 40, 50, 60, 90 };
        int val = 100;

        Arrays.sort(arr);
        int trips = 0, i = 0, j = arr.length - 1;
        while (i <= j) {
            if (arr[i] + arr[j] <= val) {
                System.out.println(arr[i] + " " + arr[j]);
                i++;
            }
            j--;
            trips++;
        }
        System.out.println("The No. of Trips: " + trips);
    }
}
