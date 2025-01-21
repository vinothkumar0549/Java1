package set4;

import java.util.Scanner;

public class Q4PrintBeforePattern {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            String term = "1";
            System.out.println(term);

            for (int i = 1; i < n; i++) {
                term = generatenext(term);
                System.out.println(term);
            }
        }
    }

    static String generatenext(String term) {
        StringBuilder newterm = new StringBuilder();
        char currchar = term.charAt(0);
        int count = 1;
        for (int i = 1; i < term.length(); i++) {
            if (term.charAt(i) == currchar) {
                count++;
            } else {
                newterm.append(count).append(currchar);
                currchar = term.charAt(i);
                count = 1;
            }
        }
        newterm.append(count).append(currchar);
        return newterm.toString();
    }
}
