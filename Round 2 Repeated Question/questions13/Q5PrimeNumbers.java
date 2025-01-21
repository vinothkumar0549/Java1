
package questions13;

import java.util.Scanner;

public class Q5PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the No of Element: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Matrix Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int num : arr) {
            boolean isprime = true;
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isprime = false;
                }
            }
            if (isprime == true) {
                System.out.print(num + " ");
            }
        }
        scanner.close();
    }
}
