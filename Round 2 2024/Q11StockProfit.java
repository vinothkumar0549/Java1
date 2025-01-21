import java.util.Scanner;

public class Q11StockProfit {
    public static void main(String[] args) {
        int min = 0, max = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[min]) {
                min = i;
                max = i;
            }
            if (arr[i] > arr[max]) {
                max = i;
            }
        }

        if (min < max) {
            System.out.println("Profit: " + (arr[max] - arr[min]));
        } else {
            System.out.println("Profit: 0");
        }
        System.out.println(min + " " + max);
        scanner.close();
    }
}
