package questions20;

import java.util.Scanner;

public class Q12Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the N: ");
        int n = scanner.nextInt();
        int temp, f1 = 0, f2 = 1;

        if (n > 0) {
            System.out.println(f1);
        }
        if (n > 1) {
            System.out.println(f2);
        }
        for (int i = 2; i < n; i++) {
            temp = f1 + f2;
            System.out.println(temp);
            f1 = f2;
            f2 = temp;
        }
        scanner.close();
    }
}
