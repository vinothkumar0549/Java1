package questions20;

import java.util.Set;
import java.util.Iterator;
import java.util.Scanner;
import java.util.HashSet;

public class Q16RemoveDuplicateElementArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements in the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            set.add(i);
        }

        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        scanner.close();
    }
}
