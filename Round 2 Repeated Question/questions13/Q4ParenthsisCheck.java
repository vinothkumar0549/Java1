package questions13;

import java.util.Scanner;

public class Q4ParenthsisCheck {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the String: ");
            String value = scanner.nextLine();

            boolean prev = false;

            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) == '(') {
                    if (prev) {
                        System.out.println(0 + " Not matched");
                        return;
                    } else {
                        prev = !prev;
                    }
                } else if (value.charAt(i) == ')') {
                    if (prev) {
                        prev = !prev;
                    } else {
                        System.out.println(0 + " Not matched");
                        return;
                    }
                }
            }
            System.out.println(1 + " matched");
        }
    }
}
