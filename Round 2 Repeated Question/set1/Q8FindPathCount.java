//source and destination will be entered as user dynamically

package set1;

import java.util.Scanner;

public class Q8FindPathCount {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Matrix: ");
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
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
            System.out.println("Enter the Source Cooridnates x and y: ");
            int srcx = scanner.nextInt();
            int srcy = scanner.nextInt();
            System.out.println("Enter the Destination Coordinates x and y: ");
            int desx = scanner.nextInt();
            int desy = scanner.nextInt();
            if (srcx < 0 || srcx >= n || srcy < 0 || srcy >= n || desx < 0 || desx >= n || desy < 0 || desy >= n) {
                System.out.println("Enter the Correct Coordinates...");
                return;
            }
            boolean[][] visited = new boolean[n][n];

            int count = findpath(matrix, srcx, srcy, desx, desy, visited);
            System.out.println(count);
        }
    }

    static boolean isvalid(int[][] matrix, int x, int y, boolean[][] visited) {
        int N = matrix.length;
        return !(x < 0 || x > N - 1 || y < 0 || y > N - 1 || matrix[x][y] == 0
                || visited[x][y]);
    }

    static int findpath(int[][] matrix, int srcx, int srcy, int desx, int desy, boolean[][] visited) {
        if (srcx == desx && srcy == desy) {
            return 1;
        }
        visited[srcx][srcy] = true;

        int findpaths = 0;

        int[] row = { -1, 1, 0, 0 };
        int[] col = { 0, 0, -1, 1 }; // All four directions...

        // int[] row = { 0, 1 };// only right and down direction
        // int[] col = { 1, 0 };

        for (int i = 0; i < 4; i++) {
            int nextx = srcx + row[i];
            int nexty = srcy + col[i];
            if (isvalid(matrix, nextx, nexty, visited)) {
                findpaths += findpath(matrix, nextx, nexty, desx, desy, visited);
            }
        }
        visited[srcx][srcy] = false;
        return findpaths;
    }

    static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Source at 0,0 and destination at N-1,N-1 static

// package set1;

// import java.util.Scanner;

// public class Q8FindPathCount {
// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// System.out.println("Enter the Size of the Matrix: ");
// int n = scanner.nextInt();
// int[][] matrix = new int[n][n];
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// matrix[i][j] = scanner.nextInt();
// }
// }
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// System.out.print(matrix[i][j] + " ");
// }
// System.out.println();
// }
// boolean[][] visited = new boolean[n][n];

// int count = findpath(matrix, 0, 0, visited);
// System.out.println(count);
// scanner.close();
// }

// static boolean isvalid(int[][] matrix, int x, int y, boolean[][] visited) {
// int N = matrix.length;
// return !(x < 0 || x >= N || y < 0 || y >= N || matrix[x][y] == 0 ||
// visited[x][y]);
// }

// static int findpath(int[][] matrix, int x, int y, boolean[][] visited) {
// int N = matrix.length;
// if (x == N - 1 && y == N - 1) {
// return 1;
// }
// visited[x][y] = true;

// int findpaths = 0;

// // int[] row = { -1, 1, 0, 0 };
// // int[] col = { 0, 0, -1, 1 }; All four directions...

// int[] row = { 0, 1 };// only right and down direction
// int[] col = { 1, 0 };

// for (int i = 0; i < 2; i++) {
// int nextx = x + row[i];
// int nexty = y + +col[i];
// if (isvalid(matrix, nextx, nexty, visited)) {
// findpaths += findpath(matrix, nextx, nexty, visited);
// }
// }
// visited[x][y] = false;
// return findpaths;
// }

// static void printMatrix(int[][] matrix) {
// int n = matrix.length;
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// System.out.print(matrix[i][j] + " ");
// }
// System.out.println();
// }
// }
// }
