package questions13;

import java.util.Scanner;

public class Q9BinaryFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        System.out.println("Enter the Number: ");
        int num = scanner.nextInt();

        while (num > 0) {
            if (num % 2 == 0) {
                builder.insert(0, "0");
            } else {
                builder.insert(0, "1");
            }
            num = num / 2;
        }
        System.out.println(builder.toString());
        scanner.close();
    }
}
