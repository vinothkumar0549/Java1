package questions106;

import java.util.Scanner;

public class Q4ColorChange {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Array M and N: ");
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println("Enter the Elements of the Array: ");
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            System.out.println("Enter the X and Y axis of the Color Change: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Enter the New Color: ");
            int newcolor = scanner.nextInt();

            if (x < 0 || x >= m || y < 0 || y >= n) {
                System.out.println("Enter the Valid x and y axis...");
                return;
            }

            int old = arr[x][y];
            if (old != newcolor) {
                fillcolor(arr, x, y, old, newcolor);
            }

            System.out.println("Screen after color change:");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    static void fillcolor(int arr[][], int x, int y, int old, int color) {
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
            return;
        }
        if (arr[x][y] != old) {
            return;
        }
        arr[x][y] = color;

        fillcolor(arr, x + 1, y, old, color);
        fillcolor(arr, x - 1, y, old, color);
        fillcolor(arr, x, y + 1, old, color);
        fillcolor(arr, x, y - 1, old, color);
    }
}