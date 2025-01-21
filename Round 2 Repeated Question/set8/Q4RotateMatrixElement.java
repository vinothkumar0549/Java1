package set8;

import java.util.Scanner;

public class Q4RotateMatrixElement {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Array x and y:");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int[][] arr = new int[x][y];
            System.out.println("Enter the Elements of the Array: ");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            System.out.println("The Array Elements are: ");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            int top = 0, bottom = x - 1, left = 0, right = y - 1, prev, curr;
            while (top < bottom && left < right) {
                prev = arr[top + 1][left];
                for (int i = left; i <= right; i++) {
                    curr = arr[top][i];
                    arr[top][i] = prev;
                    prev = curr;
                }
                top++;
                for (int i = top; i <= bottom; i++) {
                    curr = arr[i][right];
                    arr[i][right] = prev;
                    prev = curr;
                }
                right--;
                if (left <= right) {
                    for (int i = right; i >= left; i--) {
                        curr = arr[bottom][i];
                        arr[bottom][i] = prev;
                        prev = curr;
                    }
                    bottom--;
                }
                if (top <= bottom) {
                    for (int i = bottom; i >= top; i--) {
                        curr = arr[i][left];
                        arr[i][left] = prev;
                        prev = curr;
                    }
                    left++;
                }
                System.out.println("The Rotation after Each Iteration: ");
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
            }

            System.out.println("The Final Result: ");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
