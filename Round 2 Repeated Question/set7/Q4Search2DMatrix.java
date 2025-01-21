package set7;

import java.util.Scanner;

public class Q4Search2DMatrix {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Array: ");
            int n = scanner.nextInt();
            char[][] arr = new char[n][n];
            System.out.println("Enter the Elements of the array: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.next().charAt(0);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            scanner.nextLine();
            System.out.println("Enter the String: ");
            String value = scanner.nextLine();
            boolean found = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    boolean[][] visited = new boolean[n][n];
                    if (arr[i][j] == value.charAt(0) &&
                            search2DMatrix(arr, value, visited, i, j, 0)) {
                        System.out.println("Found: " + value);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (!found) {
                System.out.println("Not Found");
            }
        }
    }

    static boolean search2DMatrix(char[][] arr, String value, boolean[][] visited, int x, int y, int k) {
        if (k == value.length()) {
            return true;
        }
        if (x < 0 || x > arr.length - 1 || y < 0 || y > arr.length - 1 || arr[x][y] != value.charAt(k)
                || visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        if (search2DMatrix(arr, value, visited, x, y + 1, k + 1)) {
            return true;
        }
        if (search2DMatrix(arr, value, visited, x + 1, y, k + 1)) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }
}
