package questions106;

import java.util.Scanner;

public class Q22LatinMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size: ");
        int n = scanner.nextInt();
        scanner.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = (char) ('A' + (i + j) % n);
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
