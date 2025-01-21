package questions106;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Q87RemoveDuplicateInsertOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new LinkedHashSet<>();
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : arr) {
            set.add(i);
        }

        for (int i : set) {
            System.out.print(i + " ");
        }
        scanner.close();
    }
}
