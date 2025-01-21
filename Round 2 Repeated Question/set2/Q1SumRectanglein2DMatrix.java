package set2;

import java.util.Scanner;

public class Q1SumRectanglein2DMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the Array x and y: ");
        int nx = scanner.nextInt();
        int ny = scanner.nextInt();
        int[][] arr = new int[nx][ny];

        System.out.println("Enter the Elements of the Matrix: ");
        for (int i = 0; i < nx; i++) {
            for (int j = 0; j < ny; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < nx; i++) {
            for (int j = 0; j < ny; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        int sx, sy, ex, ey, sum = 0;
        System.out.println("Enter the Start Index and End Index: ");
        sx = scanner.nextInt();
        sy = scanner.nextInt();
        ex = scanner.nextInt();
        ey = scanner.nextInt();
        System.out.println(sx + " " + sy + " " + ex + " " + ey);

        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                System.out.print(arr[i][j]);
                sum += arr[i][j];
            }
            System.out.println();
        }
        System.out.println(sum);
        scanner.close();
    }
}
