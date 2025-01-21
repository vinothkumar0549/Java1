package questions20;

import java.util.TreeSet;
import java.util.Scanner;

public class Q9ArrayIntersection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> s1 = new TreeSet<>();
        TreeSet<Integer> intersection = new TreeSet<>();
        int[] arr1 = createarray(scanner);
        int[] arr2 = createarray(scanner);

        for (int i : arr1) {
            s1.add(i);
        }
        for (int i : arr2) {
            if (s1.contains(i)) {
                intersection.add(i);
            }
        }
        for (int i : intersection) {
            System.out.print(i + " ");
        }
    }

    static int[] createarray(Scanner scanner) {
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
