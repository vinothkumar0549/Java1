package set6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Q3SortUsingOccurence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            tree.computeIfPresent(e.getValue(), (key, value) -> {
                value.add(e.getKey());
                return value;
            });
            tree.putIfAbsent(e.getValue(), new ArrayList<>(Arrays.asList(e.getKey())));
        }

        for (Map.Entry<Integer, ArrayList<Integer>> e : tree.descendingMap().entrySet()) {
            for (int i : e.getValue()) {
                for (int j = 0; j < e.getKey(); j++) {
                    System.out.print(i + " ");
                }
            }
        }
        scanner.close();
    }
}
