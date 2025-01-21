package questions106;

import java.util.Scanner;

public class Q13CrossPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sentence: ");
        String word = scanner.nextLine();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if (i == j || j == word.length() - i - 1) {
                    System.out.print(word.charAt(i));
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
