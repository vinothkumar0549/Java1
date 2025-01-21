package set5;

import java.util.Scanner;

public class Q3AddNotoNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int number = scanner.nextInt();
        System.out.println("Enter the Value to be Add: ");
        int val = scanner.nextInt();

        String result = addnumber(number, val);
        System.out.println(result);

        scanner.close();
    }

    static String addnumber(int number, int val) {
        if (number < 10) {
            return Integer.toString(number + val);
        }
        return addnumber(number / 10, val) + String.valueOf((number % 10) + val);
    }
}
