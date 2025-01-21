package questions13;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Q11RemoveDuplicateElementTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the No. of Tests: ");
        int t = scanner.nextInt();

        for (int k = 0; k < t; k++) {
            System.out.println("Enter the Size of the Array: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the Elements of the Array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                set.add(arr[i]);
            }

            list.add(set.size());
            set.clear();
        }

        for (int i : list) {
            System.out.println(i);
        }
        scanner.close();
    }
}
