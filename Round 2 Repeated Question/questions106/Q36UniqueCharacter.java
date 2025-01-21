package questions106;

import java.util.LinkedHashSet;

public class Q36UniqueCharacter {
    public static void main(String[] args) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        String input = "ccdefhaabbb";
        for (char c : input.toCharArray()) {
            set.add(c);
        }
        for (char c : set) {
            System.out.print(c);
        }

    }
}
