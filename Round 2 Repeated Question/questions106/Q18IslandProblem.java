package questions106;

import java.util.Scanner;

public class Q18IslandProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Matrix X and Y: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] arr = new int[x][y];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || i == x - 1 || j == 0 || j == y - 1) {
                    continue;
                }
                if (arr[i][j] == 1 && arr[i - 1][j] == -1 && arr[i + 1][j] == -1 && arr[i][j - 1] == -1
                        && arr[i][j + 1] == -1) {
                    System.out.println(i + " " + j);
                }
            }
        }
        scanner.close();
    }
}
