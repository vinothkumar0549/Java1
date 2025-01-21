package set4;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Q2SortFactorofNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();
            System.out.println("Enter the Size of the Array: ");
            int n = scanner.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter the Elements of the Array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i : arr) {
                int count = 0;
                for (int j = 1; j < Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        count++;
                    } else if (j != i / j) {
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
            System.out.println(tree);
            for (Map.Entry<Integer, ArrayList<Integer>> e : tree.descendingMap().entrySet()) {
                ArrayList<Integer> list = e.getValue();
                // Collections.sort(list, Collections.reverseOrder());
                Collections.sort(list, new Comparator<Integer>() {
                    public int compare(Integer i, Integer j) {
                        if (i > j) {
                            return 1;
                        } else if (j > i) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
                for (int i : list) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            System.out.println(tree);
        }

    }
}
