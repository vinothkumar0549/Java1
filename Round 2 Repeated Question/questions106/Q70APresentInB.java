package questions106;

import java.util.Scanner;

public class Q70APresentInB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values for a and b: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        boolean result = isAPresentInB(a, b);
        System.out.println(result ? "True" : "False");
    }

    static boolean isAPresentInB(int a, int b) {
        // Convert 'a' to a string to get its length
        String strA = Integer.toString(a);
        int lenA = strA.length();

        while (b > 0) {
            if (b % Math.pow(10, lenA) == a) {
                return true;
            }
            b = b / 10;
        }
        return false;
    }
}
