package questions20;

import java.util.Scanner;

public class Q10Matrix90DegreeRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of Array: ");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }

        }
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

                // arr[i][j] = arr[i][j] + arr[j][i];
                // arr[j][i] = arr[i][j] - arr[j][i]; // swap without temp
                // arr[i][j] = arr[i][j] - arr[j][i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
