package questions20;

import java.util.Scanner;

public class Q2PrimeNumbers {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int num : arr) {
            boolean isprime = true;
            for (int j = 2; j <= num / 2; j++) {
                if (num % j == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime) {
                System.out.print(num + " ");
            }
        }
        scanner.close();
    }
}
