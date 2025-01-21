package questions106;

import java.util.Scanner;

public class Q42SameAddNextIndRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] newarr = new int[n];

        int i = 0, j = n - 1;

        for (int k = 0; k < n; k++) {
            if (arr[k] == 0) {
                newarr[j--] = 0;
            } else if (((k + 1) < n) && arr[k] == arr[k + 1]) {
                newarr[i++] = arr[k] * 2;
                arr[k + 1] = 0;
            } else {
                newarr[i++] = arr[k];
            }
        }
        for (int k : newarr) {
            System.out.print(k + " ");
        }
        scanner.close();
    }
}
