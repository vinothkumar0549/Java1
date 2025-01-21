package questions106;

import java.util.Scanner;

public class Q66DigitAddEachNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Nuber: ");
        int num = scanner.nextInt();
        System.out.println("Enter the Digit: ");
        int digit = scanner.nextInt();

        String result = addnumber(num, digit);

        // int intresult = Integer.valueOf(result);
        System.out.println(result);
        scanner.close();
    }

    static String addnumber(int num, int digit) {
        if (num == 0) {
            return "";
        }
        return addnumber(num / 10, digit) + Integer.toString((num % 10) + digit);
    }
}
