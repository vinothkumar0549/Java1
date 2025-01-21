package questions106;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q68LexicographicSorting {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Bannana", "Mongo", "Grapes", "Apple", "Kiwi"));
        System.out.println(list);
        Collections.sort(list, (a, b) -> a.compareTo(b));
        System.out.println(list);
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
