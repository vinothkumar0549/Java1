package set2;

import java.util.Scanner;
import java.util.ArrayList;

public class Q3RemovePalindromeWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();
        System.out.println("Enter the String: ");
        String Line = scanner.nextLine();

        for (int i = 0; i < Line.length(); i++) {
            if (Line.charAt(i) == ' ') {
                words.add(word.toString());
                word.setLength(0);
                continue;
            }
            word.append(Line.charAt(i));
        }
        words.add(word.toString());
        word.setLength(0);

        for (String w : words) {
            // System.out.println(w);
            int l = 0, r = w.length() - 1;
            while (l <= r) {
                if (w.charAt(l) == w.charAt(r)) {
                    l++;
                    r--;
                    continue;
                } else {
                    word.append(w + " ");
                    break;
                }
            }
        }
        System.out.println(word.toString());
        scanner.close();
    }
}

// package set2;

// import java.util.Scanner;

// public class Q3RemovePalindromeWords {
// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// System.out.println("Enter the sentence: ");
// String sentence = scanner.nextLine();
// scanner.close();

// StringBuilder result = new StringBuilder();
// StringBuilder word = new StringBuilder();

// for (char c : sentence.toCharArray()) {
// if (c == ' ') {
// if (word.length() > 0 && !isPalindrome(word.toString())) {
// result.append(word).append(" ");
// }
// word.setLength(0); // reset the word
// } else {
// word.append(c);
// }
// }

// // Check the last word
// if (word.length() > 0 && !isPalindrome(word.toString())) {
// result.append(word);
// }

// System.out.println(result.toString().trim());
// }

// private static boolean isPalindrome(String word) {
// int start = 0;
// int end = word.length() - 1;
// while (start < end) {
// if (word.charAt(start) != word.charAt(end)) {
// return false;
// }
// start++;
// end--;
// }
// return true;
// }
// }
