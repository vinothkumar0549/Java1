package questions106;

import java.util.Scanner;

public class Q99PatternProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String value = scanner.nextLine();

        int k = value.length() / 2;

        for (int i = 0; i < value.length(); i++) {
            for (int j = 0; j < value.length(); j++) {
                if (j < value.length() - i - 1) {
                    System.out.print(" ");
                    continue;
                }
                if (k == value.length()) {
                    k = 0;
                }
                System.out.print(value.charAt(k++));
            }
            System.out.println();
            k = (value.length() / 2) % value.length();
        }
        scanner.close();
    }
}

// import java.util.Scanner;

// public class PatternProgram {
// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// System.out.println("Enter the String: ");
// String value = scanner.nextLine();

// if (value.length() % 2 == 0) {
// System.out.println("The input string length should be odd.");
// } else {
// printPattern(value);
// }

// scanner.close();
// }

// private static void printPattern(String value) {
// int len = value.length();
// int mid = len / 2;

// for (int i = 0; i < len; i++) {
// // Print leading spaces
// for (int j = 0; j < len - i - 1; j++) {
// System.out.print(" ");
// }

// // Print characters
// for (int j = mid; j <= mid + i; j++) {
// System.out.print(value.charAt(j % len));
// }

// System.out.println();
// }
// }
// }
