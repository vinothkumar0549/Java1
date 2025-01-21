package questions106;

import java.util.Scanner;

public class Q16GridStartToEnd {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Array: ");
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            boolean[][] visited = new boolean[n][n];
            System.out.println(findpath(matrix, 0, 0, visited));
        }

    }

    static boolean findpath(int[][] matrix, int x, int y, boolean[][] visited) {
        int N = matrix.length;
        if (x < 0 || x >= N || y < 0 || y >= N || matrix[x][y] == 0 || visited[x][y]) {
            // printMatrix(visited);
            return false;
        }
        visited[x][y] = true;
        if (x == N - 1 && y == N - 1) {
            // printMatrix(visited);
            return true;
        }

        if (findpath(matrix, x, y + 1, visited)) {
            // printMatrix(visited);
            return true;
        }

        if (findpath(matrix, x + 1, y, visited)) {
            // printMatrix(visited);
            return true;
        }
        visited[x][y] = false;
        // printMatrix(visited);
        return false;
    }

    // static void printMatrix(boolean[][] visited) {
    // int N = visited.length;
    // for (int x = 0; x < N; x++) {
    // for (int y = 0; y < N; y++) {
    // System.out.print(visited[x][y] + " ");
    // }
    // System.err.println();
    // }
    // System.out.println();
    // }
}
