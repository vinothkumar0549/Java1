package questions106;

import java.util.Scanner;

public class Q21SnakePattern {
    public static void main(String[] args) {
        int k = 1;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    System.out.print(k++ + " ");
                }
                System.out.println();
            } else {
                int temp = k + n - 1;
                for (int j = 0; j < n; j++) {
                    System.out.print(temp-- + " ");
                    k++;
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}
