// package questions13;

// //mport java.util.HashMap;
// import java.util.LinkedHashMap;
// import java.util.Map;
// import java.util.Scanner;

// public class Q12ZeroOneTwo {
//     public static void main(String[] args) {
//         LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>() {
//             {
//                 put(0, 0);
//                 put(1, 0);
//                 put(2, 0);
//             }
//         };
//         System.out.println("Enter the Size of the Array: ");
//         Scanner scanner = new Scanner(System.in);
//         int n = scanner.nextInt();
//         int[] arr = new int[n];
//         System.out.println("Enter the Elements of the Array: ");
//         for (int i = 0; i < n; i++) {
//             arr[i] = scanner.nextInt();
//         }

//         for (int i : arr) {
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }

//         for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//             for (int i = 0; i < e.getValue(); i++) {
//                 System.out.print(e.getKey() + " ");
//             }
//         }
//         scanner.close();
//     }
// }

package questions13;

import java.util.Scanner;

public class Q12ZeroOneTwo {
    public static void main(String[] args) {
        System.out.println("Enter the Size of the Array: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        sortzeroonetwo(arr);

        for (int i : arr) {
            System.out.print(i + " ");
            ;
        }
        scanner.close();
    }

    static void sortzeroonetwo(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    sortswap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    sortswap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }

    static void sortswap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
