package questions106;

import java.util.Scanner;

public class Q97LargeSumSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE, maxend = 0, start = 0, s = 0, e = 0;

        for (int i = 0; i < n; i++) {
            maxend += arr[i];
            if (max < maxend) {
                max = maxend;
                start = s;
                e = i;
            }
            if (maxend < 0) {
                maxend = 0;
                s = i + 1;
            }
        }
        System.out.println(max);
        for (int i = start; i <= e; i++) {
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }
}
