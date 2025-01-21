package questions13;

import java.util.Scanner;

public class Q2DiagonalSum {
    public static void main(String[] args) {
        // int[][] arr = new int[][] { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1, 2, 3, 4,
        // 5, 6, 7, 8, 9, 10 },
        // { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1, 2,
        // 3, 4, 5, 6, 7, 8, 9, 10 },
        // { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1, 2,
        // 3, 4, 5, 6, 7, 8, 9, 10 },
        // { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 } };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Row and Columns: ");
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[] arr[] = new int[r][c];
        System.out.println("Enter the Matrix Elements: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        System.out.println(sum);
        scanner.close();
    }
}