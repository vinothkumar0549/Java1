package set5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

public class Q2SortFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];
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
            ArrayList<Integer> list = map.get(count);
            if (list == null) {
                map.put(count, new ArrayList<>(Arrays.asList(i)));
            } else {
                list.add(i);
                Collections.sort(list);
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            for (int i : e.getValue()) {
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }
}
