package questions106;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Collections;

public class Q65PrimeFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : arr) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            ArrayList<Integer> list = tree.get(count);
            if (list == null) {
                tree.put(count, new ArrayList<>(Arrays.asList(i)));
            } else {
                list.add(i);
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> e : tree.descendingMap().entrySet()) {
            Collections.sort(e.getValue(), Collections.reverseOrder());
            for (int i : e.getValue()) {
                System.out.print(i + " ");
            }
        }
        System.out.println(tree);
        scanner.close();
    }
}
