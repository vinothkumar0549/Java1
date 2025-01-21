package questions13;

import java.util.Scanner;

public class Q1CoinToss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the No. of Trails: ");
        int n = scanner.nextInt();
        System.out.println("Enter the Success: ");
        int r = scanner.nextInt();

        double numerator = factorial(n, n - r + 1);
        double denominator = factorial(r, 1);

        double probability = (numerator / denominator) * Math.pow(0.5, r) * Math.pow(0.5, n - r);

        System.out.println(probability);
        scanner.close();
    }

    static double factorial(int start, int end) {
        if (start == end) {
            return start;
        }
        return start * factorial(start - 1, end);

    }
}
