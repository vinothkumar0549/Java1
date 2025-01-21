package questions106;

import java.util.Scanner;

public class Q27NumberPalindrome {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int num = scanner.nextInt();
            int revnum = 0;
            int temp = num;
            while (num > 0) {
                revnum = (revnum * 10) + (num % 10);
                num = num / 10;
            }

            System.out.println(temp + " " + revnum);

            if (temp == revnum) {
                System.out.println("The Number is Palindrom...");
            } else {
                System.out.println("The Number is Not Palindrom...");
            }
        }
    }
}
