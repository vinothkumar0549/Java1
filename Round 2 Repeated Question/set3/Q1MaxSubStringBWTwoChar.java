package set3;

import java.util.HashMap;

public class Q1MaxSubStringBWTwoChar {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        String input = "aaaaaaaa";
        int maxlength = 0;
        int s = 0;
        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(input.charAt(i))) {
                if (i - map.get(input.charAt(i)) > maxlength) {
                    maxlength = i - map.get(input.charAt(i));
                    s = map.get(input.charAt(i));
                    continue;
                }
            }
            map.put(input.charAt(i), i);
        }
        System.out.println(map);
        System.out.println(s + " " + (maxlength - 1));
    }
}
