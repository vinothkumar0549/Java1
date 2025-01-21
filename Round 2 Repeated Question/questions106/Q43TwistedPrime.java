package questions106;

import java.util.Scanner;

public class Q43TwistedPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int num = scanner.nextInt();
        int reverse = 0;

        boolean primenum1 = isprime(num);

        while (num > 0) {
            reverse = (reverse * 10) + (num % 10);
            num = num / 10;
        }

        boolean primenum2 = isprime(reverse);

        if (primenum1 && primenum2) {
            System.out.println("Twisted Prime Number");
        } else {
            System.out.println("Not Twisted Prime Number");
        }
        scanner.close();
    }

    static boolean isprime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
