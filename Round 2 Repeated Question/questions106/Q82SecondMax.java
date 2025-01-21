package questions106;

import java.util.Scanner;

public class Q82SecondMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int max = Integer.MIN_VALUE, smax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                smax = max;
                max = arr[i];
            }
            if (arr[i] != max && arr[i] > smax) {
                smax = arr[i];
            }
        }
        System.out.printf("The Second Maximum: %d", smax);
        scanner.close();
    }
}
