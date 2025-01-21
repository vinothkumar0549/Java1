
package questions20;

import java.util.Scanner;

public class Q18kadaneMaximumSumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
