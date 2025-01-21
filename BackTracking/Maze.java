import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    static int[] rowdir = { 0, 0, -1, 1 };
    static int[] coldir = { -1, 1, 0, 0 };

    static String direction = "LRUD";
    // static boolean findsolution = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] maze = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        if (maze[0][0] == 0) {
            scanner.close();
            return;
        }

        findPath(0, 0, n, maze, result, path);

        for (String s : result) {
            System.out.println(s);
        }

        scanner.close();
    }

    static void findPath(int row, int col, int n, int[][] maze, List<String> result, StringBuilder path) {
        int nextx, nexty;

        // if (findsolution) {
        // return;
        // }

        if (row == n - 1 && col == n - 1) {
            result.add(path.toString());
            // findsolution = true;
            return;
        }
        maze[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            nextx = row + rowdir[i];
            nexty = col + coldir[i];

            if (isvalid(nextx, nexty, n, maze)) {
                path.append(direction.charAt(i));
                findPath(nextx, nexty, n, maze, result, path);
                // if (findsolution) {
                // return;
                // }
                path.deleteCharAt(path.length() - 1);
            }
        }
        maze[row][col] = 1;

    }

    static boolean isvalid(int row, int col, int n, int[][] maze) {
        return (row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1);
    }
}
