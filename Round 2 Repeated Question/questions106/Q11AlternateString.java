package questions106;

import java.util.Scanner;

public class Q11AlternateString {
    public static void main(String[] args) {
        StringBuilder builderodd = new StringBuilder();
        StringBuilder buildereven = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String word = scanner.next();
        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 1) {
                builderodd.append(word.charAt(i));
            } else {
                buildereven.append(word.charAt(i));
            }
        }
        System.out.println(buildereven.toString() + " " + builderodd.toString());
        scanner.close();

    }
}
