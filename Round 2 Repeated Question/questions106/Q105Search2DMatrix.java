package questions106;

import java.util.Scanner;

public class Q105Search2DMatrix {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Array: ");
            int n = scanner.nextInt();
            char[][] arr = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.next().charAt(0);
                }
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            scanner.nextLine();
            System.out.print("Enter the Search String: ");
            String value = scanner.nextLine();

            boolean found = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    boolean[][] visited = new boolean[n][n]; // reset visited array for each start point
                    if (search2DMatrix(arr, value, visited, i, j, 0)) {
                        System.out.println("Found: " + value);
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }

            if (!found) {
                System.out.println("Not Found...");
            }
        }
    }

    static boolean search2DMatrix(char[][] arr, String value, boolean[][] visited, int x, int y, int k) {
        if (k == value.length()) {
            return true;
        }
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] != value.charAt(k) || visited[x][y]) {
            return false;
        }

        visited[x][y] = true;

        // Move right
        if (search2DMatrix(arr, value, visited, x, y + 1, k + 1)) {
            return true;
        }

        // Move down
        if (search2DMatrix(arr, value, visited, x + 1, y, k + 1)) {
            return true;
        }

        visited[x][y] = false;
        return false;
    }
}
