package questions106;

import java.util.HashSet;

public class Q76FibonacciSeriesContains {
    public static void main(String[] args) {
        // int[] arr = { 1, 10, 6, 8, 13, 21 };
        int[] arr = { 2, 10, 4, 8 };
        int max = findmax(arr);
        HashSet<Integer> set = generateHashSet(max);
        for (int i : arr) {
            if (set.contains(i)) {
                System.out.print(i + " ");
            }
        }

    }

    static HashSet<Integer> generateHashSet(int max) {
        HashSet<Integer> set = new HashSet<>();
        int a = 0, b = 1;
        if (max >= 0) {
            set.add(a);
        }
        if (max >= 1) {
            set.add(b);
        }
        while (b <= max) {
            int temp = a + b;
            a = b;
            b = temp;
            if (b <= max) {
                set.add(b);
            }
        }
        return set;
    }

    static int findmax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
