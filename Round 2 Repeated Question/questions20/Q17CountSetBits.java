package questions20;

import java.util.Scanner;

public class Q17CountSetBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int num = scanner.nextInt();

        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        System.out.println(count);
        scanner.close();
    }
}
