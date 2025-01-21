package set3;

import java.util.List;
import java.util.ArrayList;

public class Q3AnagramGrouping {
    public static void main(String[] args) {
        String[] words = { "catch", "got", "tiger", "mat", "eat", "ate", "pat", "tap", "tea" };
        String target = "tap";

        List<String> result = checkanagram(words, target);

        for (String word : result) {
            System.out.print(word + " ");
        }
    }

    static List<String> checkanagram(String[] words, String target) {
        List<String> result = new ArrayList<>();

        int targetasciisum = checkasciisum(target);
        int[] targetfrequency = checkfrequency(target);

        for (String word : words) {
            if (target.length() == word.length() & targetasciisum == checkasciisum(word)
                    & issamefrequency(checkfrequency(word), targetfrequency)) {
                result.add(word);
            }
        }
        return result;
    }

    static int checkasciisum(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += word.charAt(i);
        }
        return sum;
    }

    static int[] checkfrequency(String word) {
        int[] frequency = new int[26];
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                frequency[c - 'a']++;
                continue;
            } else {
                return new int[0];
            }
        }
        return frequency;
    }

    static boolean issamefrequency(int[] f1, int[] f2) {
        if (f1.length != f2.length) {
            return false;
        }
        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }
        return true;
    }
}
