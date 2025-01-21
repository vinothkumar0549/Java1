package set5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Q4LexicoGraphicalSort {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Banna", "Graphes", "Mongo", "Apple", "Carrot"));
        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });

        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
