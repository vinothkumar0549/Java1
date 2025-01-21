package questions20;

import java.util.Scanner;

public class Q15BinarySearch {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Size of the Array: ");
            int n = scanner.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter the Elements of the Array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println("Enter the Target: ");
            int target = scanner.nextInt();
            int m, l = 0, r = arr.length - 1;
            while (l <= r) {
                m = l + (r - l) / 2;
                System.out.println(l + " " + m + " " + r);
                if (arr[m] == target) {
                    System.out.println(arr[m] + " at " + m);
                    return;
                } else {
                    if (arr[m] > target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            }
            System.out.println("The Target is not Found");
        }
    }
}
