package questions106;

import java.util.Scanner;

public class Q106ReverseStringRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String value = scanner.nextLine();

        String reverse = reverseString(value);
        System.out.println(reverse);
        scanner.close();
    }

    static String reverseString(String value) {
        // System.out.println(value);
        if (value.lastIndexOf(" ") == -1) {
            return value;
        }
        return value.substring(value.lastIndexOf(" ") + 1, value.length()) + " "
                + reverseString(value.substring(0, value.lastIndexOf(" ")));
    }
}
