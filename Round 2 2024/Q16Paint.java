import java.util.Scanner;

public class Q16Paint {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size x and y: ");
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            char[][] arr = new char[m][n];
            System.out.println("Enter the Color of the Array: ");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.next().charAt(0);
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Enter the New Color: ");
            char newcolor = scanner.next().charAt(0);
            System.out.println("Enter the Target x and y: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x < 0 || x >= m || y < 0 || y >= n) {
                System.out.println("Invalid Index...");
                return;
            }
            char oldcolor = arr[x][y];
            if (oldcolor != newcolor) {
                fillcolor(arr, x, y, oldcolor, newcolor);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    static void fillcolor(char arr[][], int x, int y, char oldcolor, char newcolor) {
        System.out.println(x + " " + y);
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
            return;
        }
        if (arr[x][y] != oldcolor) {
            return;
        }
        arr[x][y] = newcolor;

        fillcolor(arr, x + 1, y, oldcolor, newcolor);
        fillcolor(arr, x - 1, y, oldcolor, newcolor);
        fillcolor(arr, x, y + 1, oldcolor, newcolor);
        fillcolor(arr, x, y - 1, oldcolor, newcolor);
    }
}
