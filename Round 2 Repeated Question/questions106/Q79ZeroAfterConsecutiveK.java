package questions106;

import java.util.Scanner;;

public class Q79ZeroAfterConsecutiveK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Array Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter the Consecutive K: ");
        int k = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                System.out.print(0 + " ");
                count = 0;
            }
        }
        scanner.close();
    }
}