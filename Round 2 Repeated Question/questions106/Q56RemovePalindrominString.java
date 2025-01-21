package questions106;

import java.util.Scanner;

public class Q56RemovePalindrominString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        System.out.println("Enter the String: ");
        String Line = scanner.nextLine();

        for (int i = 0; i < Line.length(); i++) {
            if (Line.charAt(i) == ' ') {
                int l = 0, r = word.length() - 1;
                while (l <= r) {
                    if (word.charAt(l) == word.charAt(r)) {
                        l++;
                        r--;
                        continue;
                    } else {
                        sentence.append(word + " ");
                        break;
                    }
                }
                word.setLength(0);
                continue;
            }
            word.append(Line.charAt(i));
        }
        int l = 0, r = word.length() - 1;
        while (l <= r) {
            if (word.charAt(l) == word.charAt(r)) {
                l++;
                r--;
                continue;
            } else {
                sentence.append(word + " ");
                break;
            }
        }
        System.out.println(sentence.toString());
        scanner.close();
    }
}
