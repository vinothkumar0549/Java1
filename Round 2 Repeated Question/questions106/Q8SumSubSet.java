package questions106;

import java.util.Scanner;
import java.util.ArrayList;

public class Q8SumSubSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter the Values: ");
        int val = scanner.nextInt();

        for (int i = 1; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) > 0) {
                    list.add(arr[j]);
                    sum += arr[j];
                }
            }
            if (sum == val) {
                System.out.print("[ ");
                for (int k : list) {
                    System.out.print(k + " ");
                }
                System.out.println("]");
            }
            list.clear();
        }
        scanner.close();
    }
}

// display all the subset

// package questions106;

// import java.util.Scanner;

// public class Q19SubSetSum {
// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// int n = scanner.nextInt();
// int[] arr = new int[n];
// for (int i = 0; i < n; i++) {
// arr[i] = scanner.nextInt();
// }

// for (int i = 1; i < (1 << n); i++) { // initializes 0 gives the emptySet []
// also...
// System.out.print("[ ");
// for (int j = 0; j < n; j++) {
// if ((i & 1 << j) > 0) {
// System.out.print(arr[j] + " ");
// }
// }
// System.out.println("]");
// }
// scanner.close();
// }
// }
