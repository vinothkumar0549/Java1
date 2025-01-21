package set4;

import java.util.Scanner;

public class Q3NumberToWords {

    static String ones[] = { "", "one", "two", "three", "four", "five", "Six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen",
            "twenty" };

    static String tens[] = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty" };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Number: ");
            int num = scanner.nextInt();
            if (num == 0) {
                System.out.println("Zero");
                return;
            }
            String word = convertword(num);
            System.out.println(word);
        }
    }

    static String convertword(int num) {
        if (num == 0) {
            return "";
        }

        if (num <= 20) {
            return ones[num];
        } else if (num < 100) {
            return tens[num / 10] + convertword(num % 10) + " ";
        } else {
            return ones[num / 100] + " Hundred " + ((num % 100 != 0) ? "and " + convertword(num % 100) : "");
        }
    }
}
