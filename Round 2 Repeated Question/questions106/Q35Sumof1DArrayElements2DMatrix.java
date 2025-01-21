package questions106;

import java.util.Scanner;

public class Q35Sumof1DArrayElements2DMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the arr[%d]", i);
            int x = scanner.nextInt();
            arr[i] = new int[x];
            for (int j = 0; j < x; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        int sum = 0;

        for (int[] subarr : arr) {
            int num = 0;
            for (int i = 0; i < subarr.length; i++) {
                num = (num * 10) + subarr[i];
            }
            sum += num;
        }
        System.out.println(sum);
        scanner.close();
    }
}