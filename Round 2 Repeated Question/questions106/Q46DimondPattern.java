package questions106;

import java.util.Scanner;

public class Q46DimondPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the N: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n * 2 - 1; i++) {
            if (i <= n) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int j = 0; j < i - n; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= (2 * n - 1) - (2 * (i - n)); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
