import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Q18PairNumbers {
    public static void main(String[] args) {
        int pair = 0;
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("Enter the Size: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pair += e.getValue() / 2;
        }

        System.out.println("The No. of Pair in the Array: " + pair);
        scanner.close();
    }
}
