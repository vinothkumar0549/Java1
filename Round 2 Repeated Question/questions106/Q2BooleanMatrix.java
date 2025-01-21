package questions106;

import java.util.Scanner;

public class Q2BooleanMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Matrix x and y: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] arr = new int[x][y];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("The Original Matrix: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr[i][j] == 1) {
                    if (i - 1 >= 0)
                        arr[i - 1][j] = 0;
                    if (i + 1 < x)
                        arr[i + 1][j] = 0;
                    if (j - 1 >= 0)
                        arr[i][j - 1] = 0;
                    if (j + 1 < y)
                        arr[i][j + 1] = 0;
                    if (i - 1 >= 0 && j - 1 >= 0)
                        arr[i - 1][j - 1] = 0;
                    if (i - 1 >= 0 && j + 1 < y)
                        arr[i - 1][j + 1] = 0;
                    if (i + 1 < x && j - 1 >= 0)
                        arr[i + 1][j - 1] = 0;
                    if (i + 1 < x && j + 1 < y)
                        arr[i + 1][j + 1] = 0;
                }
            }
        }
        System.out.println("\nThe Modified Matrix: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
