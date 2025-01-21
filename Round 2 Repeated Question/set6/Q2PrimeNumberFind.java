package set6;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Q2PrimeNumberFind {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> result = new ArrayList<Integer>();
            System.out.println("Enter the Size of the Array 1: ");
            int n1 = scanner.nextInt();
            int[] arr1 = new int[n1];
            System.out.println("Enter the Elements in the Array 1: ");
            for (int i = 0; i < n1; i++) {
                arr1[i] = scanner.nextInt();
            }

            System.out.println("Enter the Size of the Array 2: ");
            int n2 = scanner.nextInt();
            int arr2[] = new int[n2];
            System.out.println("Enter the Elements in the Array 2: ");
            for (int i = 0; i < n2; i++) {
                arr2[i] = scanner.nextInt();
            }

            if (n1 != n2) {
                System.out.println("Enter the Two Arrays at the Same Size");
                return;
            }
            for (int i = 0; i < n2; i++) {
                result.add(findsmallestprime(arr1[i], arr2[i]));
            }

            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }

    static int findsmallestprime(int a, int b) {
        for (int i = 1; i < 1000; i++) {
            if (isprime(i) && (a + i) % b == 0) {
                return i;
            }
        }
        return -1;
    }

    static boolean isprime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
