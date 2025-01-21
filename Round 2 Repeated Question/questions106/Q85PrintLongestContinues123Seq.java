package questions106;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.ArrayList;

public class Q85PrintLongestContinues123Seq {
    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("enter the Size of the Array: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the Elements of the Array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                tree.add(arr[i]);
            }
            int temp = tree.first();
            ArrayList<Integer> max = new ArrayList<>();
            ArrayList<Integer> curr = new ArrayList<>();

            for (int i : tree) {
                System.out.println("!!!!!");
                if (i == temp) {
                    curr.add(i);
                } else {
                    if (curr.size() > max.size()) {
                        max = new ArrayList<>(curr);
                    }
                    curr.clear();
                    curr.add(i);
                }
                temp = i + 1;
            }
            if (curr.size() > max.size()) {
                max = new ArrayList<>(curr);
            }
            for (int i : max) {
                System.out.print(i + " ");
            }
        }

    }
}
