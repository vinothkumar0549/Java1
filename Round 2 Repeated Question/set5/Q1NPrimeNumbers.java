package set5;

import java.util.Scanner;

public class Q1NPrimeNumbers {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Number: ");
            int n = scanner.nextInt();

            if (n < 2) {
                System.out.println("Invalid Input...");
                return;
            }

            for (int i = 2; i < n; i++) {
                boolean isprime = true;
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        isprime = false;
                    }
                }
                if (isprime) {
                    System.out.print(i + " ");
                }
            }
        }

    }
}
