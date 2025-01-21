package questions106;

import java.util.Scanner;

public class Q80FindMaxOfThreeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Three Number a,b,c: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max = (a > b) ? ((a > c) ? a : c) : (b > c) ? b : c;

        System.out.println(max);
        scanner.close();
    }
}
