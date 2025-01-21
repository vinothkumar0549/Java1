// import java.util.Scanner;

// public class TwoSumTarget {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Enter the Size of the Array: ");
//         int n = scanner.nextInt();
//         System.out.println("Enter the Target: ");
//         int target = scanner.nextInt();
//         int[] arr = new int[n];
//         System.out.println("Enter the Elements of the Array: ");
//         for (int i = 0; i < n; i++) {
//             arr[i] = scanner.nextInt();
//         }
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (arr[i] + arr[j] == target) {
//                     System.out.println(i + " " + j);
//                 }
//             }
//         }
//         scanner.close();
//     }
// }
package questions20;

import java.util.Scanner;
import java.util.HashMap;

public class Q7TwoSumTarget {

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
        System.out.println("Enter the Target: ");
        int target = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int complement = target - arr[i];

            if (map.containsKey(arr[i])) {
                System.out.println(map.get(arr[i]) + " " + i);
            } else {
                map.put(complement, i);
            }
        }
        scanner.close();
    }
}