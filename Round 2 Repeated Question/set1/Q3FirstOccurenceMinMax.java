package set1;

import java.util.TreeMap;
import java.util.Scanner;

public class Q3FirstOccurenceMinMax {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TreeMap<Integer, Character> tree = new TreeMap<>();
            System.out.println("Enter the String1 and String2: ");
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            for (int i = 0; i < str2.length(); i++) {
                if (str1.indexOf(str2.charAt(i)) != -1) {
                    tree.put(str1.indexOf(str2.charAt(i)), str2.charAt(i));
                }
            }
            // System.out.println(tree);
            if (!tree.isEmpty()) {
                int s = tree.firstKey();
                int e = tree.lastKey();
                for (int i = s; i <= e; i++) {
                    System.out.print(str1.charAt(i));
                }
            } else {
                System.out.println("No SubString Found");
                return;
            }
        }
    }
}
