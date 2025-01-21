package questions106;

import java.util.Scanner;

public class Q78PrintFindPath {
    // static int n;
    // static int[][] matrix = new int[n][n];

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Matrix: ");
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            System.out.println("Enter the Elements of the Matrix: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(findpath(matrix, 0, 0));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static boolean findpath(int[][] matrix, int x, int y) {
        int N = matrix.length;
        if (x < 0 || y >= N || y < 0 || y >= N || matrix[x][y] == 0 || matrix[x][y] == -1) {
            return false;
        }
        int data = matrix[x][y];
        matrix[x][y] = -1;
        if (x == N - 1 && y == N - 1) {
            return true;
        }
        if (findpath(matrix, x, y + 1)) {
            return true;
        }
        if (findpath(matrix, x + 1, y)) {
            return true;
        }
        matrix[x][y] = data;
        return false;
    }
}
