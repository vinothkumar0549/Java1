package questions13;

import java.util.Scanner;

public class Q3SingleVowelRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = scanner.nextLine();

        StringBuilder builder = new StringBuilder();
        boolean prev = false;

        for (int i = 0; i < str.length() - 1; i++) {
            if (checkvowel(str.charAt(i)) && checkvowel(str.charAt(i + 1))) {
                builder.append(str.charAt(i));
                prev = true;
            } else if (!checkvowel(str.charAt(i))) {
                builder.append(str.charAt(i));
            } else if (prev) {
                builder.append(str.charAt(i));
                prev = false;
            }
        }

        if ((prev && checkvowel(str.charAt(str.length() - 1))) || !checkvowel(str.charAt(str.length() - 1))) {
            builder.append(str.charAt(str.length() - 1));
        }

        System.out.println(builder.toString());
        scanner.close();

    }

    static boolean checkvowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
