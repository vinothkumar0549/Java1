import java.util.Scanner;

public class WildCardPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Text: ");
        String text = scanner.nextLine();
        System.out.println("Enter the Pattern: ");
        String pattern = scanner.nextLine();

        System.out.println(checkpattern(text, pattern));
        scanner.close();
    }

    static boolean checkpattern(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int i = 0, j = 0, match = 0, sidx = -1;

        while (i < n) {

            if (j < m && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < m && pattern.charAt(j) == '*') {
                sidx = j;
                match = i;
                j++;
            } else if (sidx != -1) {
                j = sidx + 1;
                match++;
                i = match;
            } else {
                return false;
            }

        }
        while (j < m && pattern.charAt(j) == '*') {
            j++;
        }
        return j == m;
    }
}
