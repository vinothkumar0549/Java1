import java.util.Scanner;

public class Q21CheckSubString {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            int index1 = 0, index2 = 0;
            while (index1 < str1.length() && index2 < str2.length()) {
                if (str1.charAt(index1) == str2.charAt(index2)) {
                    index1++;
                }
                index2++;
            }
            if (str1.length() == index1) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}
