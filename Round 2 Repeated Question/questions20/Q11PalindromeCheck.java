package questions20;

import java.util.Scanner;

public class Q11PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String value = scanner.nextLine();
        StringBuilder builder = new StringBuilder();

        for (int i = value.length() - 1; i >= 0; i--) {
            builder.append(value.charAt(i));
        }
        System.out.println(builder.toString());

        if (builder.toString().equals(value)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
        scanner.close();
    }
}
