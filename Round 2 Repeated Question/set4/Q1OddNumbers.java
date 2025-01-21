package set4;

import java.util.Scanner;

public class Q1OddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Start and End Range: ");
        int s = scanner.nextInt();
        int e = scanner.nextInt();

        for (int i = s; i < e; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }
}
