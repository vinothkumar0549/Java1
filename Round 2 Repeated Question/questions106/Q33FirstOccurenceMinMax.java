package questions106;

import java.util.Scanner;
import java.util.TreeMap;

public class Q33FirstOccurenceMinMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Character> tree = new TreeMap<>();
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        for (int i = 0; i < str2.length(); i++) {
            if (str1.indexOf(str2.charAt(i)) != -1) {
                tree.put(str1.indexOf(str2.charAt(i)), str2.charAt(i));
            }
        }

        int s = tree.firstKey();
        int e = tree.lastKey();

        System.out.println(tree);
        for (int i = s; i <= e; i++) {
            System.out.print(str1.charAt(i) + " ");
        }
        scanner.close();
    }
}
