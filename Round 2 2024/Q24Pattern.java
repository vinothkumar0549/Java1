import java.util.Scanner;

public class Q24Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number of Lines: ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            int val = i, k = n - 1;
            for (int j = 1; j < i; j++) {
                val = val + k--;
                System.out.print(val + " ");
            }
            System.out.println();

        }
        scanner.close();
    }
}
