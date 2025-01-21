package questions106;

import java.util.Scanner;

public class Q64NPrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the N: ");
        int n = scanner.nextInt();
        for (int i = 2; i < n; i++) {
            boolean isprime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime) {
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }

}