package questions106;

import java.util.Scanner;

public class Q49RemoveS2letterfromS1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String 1: ");
        String s1 = scanner.nextLine();
        System.out.println("Enter the String 2: ");
        String s2 = scanner.nextLine();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            boolean isrepeat = false;
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    isrepeat = true;
                }
            }
            if (!isrepeat) {
                builder.append(s1.charAt(i));
            }
        }
        s1 = String.valueOf(builder);
        System.out.println(s1);
        scanner.close();
    }
}
