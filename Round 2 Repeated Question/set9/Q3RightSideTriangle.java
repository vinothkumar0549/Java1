package set9;

import java.util.Scanner;

public class Q3RightSideTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Triangle: ");
        int n = scanner.nextInt();
        int k = 1;
        for (int i = 0; i < n; i++) {
            int temp = k + i;
            for (int j = 0; j <= i; j++) {
                System.out.print(temp--);
                k++;
            }
            System.out.println();
        }
        k--;
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print(k--);
            }
            System.out.println();
        }
        scanner.close();
    }
}
