package questions20;

import java.util.Scanner;
import java.util.HashSet;

public class Q6NonRepeatCharacterSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String input = scanner.nextLine();
        checknonrepeat(input);
        scanner.close();
    }

    static void checknonrepeat(String input) {
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int startposition = 0;
        int maxlength = 0;
        while (end < input.length()) {
            if (!set.contains(input.charAt(end))) {
                set.add(input.charAt(end));
                end++;
                if (end - start > maxlength) {
                    maxlength = end - start;
                    startposition = start;
                }
            } else {
                set.remove(input.charAt(start));
                start++;
            }
        }
        for (int i = startposition; i < startposition + maxlength; i++) {
            System.out.print(input.charAt(i));
        }
        // System.out.println("The Non Repeated SubString: " +
        // input.substring(startposition, startposition + maxlength));
        // System.out.println("startposition: " + startposition + " Start: " + start + "
        // MaxLength: " + maxlength + " End: " + end);
    }
}