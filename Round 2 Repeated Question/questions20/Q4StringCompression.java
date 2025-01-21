package questions20;

import java.util.Scanner;

public class Q4StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        System.out.println("Enter the String: ");
        String value = scanner.nextLine();
        int count = 1;
        for (int i = 0; i < value.length(); i++) {
            if (i < value.length() - 1 && value.charAt(i) == value.charAt(i + 1)) {
                count++;
            } else {
                builder.append(value.charAt(i) + "" + count);
                count = 1;
            }
        }
        System.out.println(builder.toString());
        scanner.close();
    }
}
