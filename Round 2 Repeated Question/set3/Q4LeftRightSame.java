package set3;

import java.util.Scanner;

public class Q4LeftRightSame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Array: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the Elements of the Array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int left = arr[0], right = arr[arr.length - 1], i = 0, j = arr.length - 1;

            while (i <= j) {
                System.out.println(i + " " + j);
                if (left == right && i == j) {
                    System.out.println(left + " " + right);
                    System.out.println("Element: " + arr[i] + " Index: " + i);
                    return;
                }
                if (left < right) {
                    left += arr[++i];
                } else if (left > right) {
                    right += arr[--j];
                } else {
                    left += arr[++i];
                    right += arr[--j];
                }
            }
        }
    }
}
