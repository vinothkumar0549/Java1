package questions13;

import java.util.Scanner;

public class Q13InBetweenValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : arr) {
            if (i > x && i < y) {
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }
}
