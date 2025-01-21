package questions20;

import java.util.HashMap;

public class Q19AnagramTwoString {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        checkanagram(str1, str2);
    }

    static void checkanagram(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s1.length() != s2.length()) {
            System.out.println("Not Anagram...");
            return;
        }
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                System.out.println("Not Anagram...");
                return;
            }
            map.put(c, map.get(c) - 1);
        }
        System.out.println("Anagram...");
    }
}

// package questions20;

// public class Q19AnagramTwoString {
// public static void main(String[] args) {
// String str1 = "silent";
// String str2 = "listen";
// checkanagram(str1, str2);
// }

// static void checkanagram(String s1, String s2) {
// int arr[] = new int[26];
// if (s1.length() != s2.length()) {
// System.out.println("Not Anagram...");
// return;
// }
// for (int i = 0; i < s1.length(); i++) {
// arr[s1.charAt(i) - 'a']++;
// arr[s2.charAt(i) - 'a']--;
// }
// for (int i = 0; i < 26; i++) {
// if (arr[i] != 0) {
// System.out.println("Not Anagram...");
// return;
// }
// }
// System.out.println("Anagram...");
// }
// }
