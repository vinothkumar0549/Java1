package set1;

import java.util.Scanner;

public class Q2PassWordCheck {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Password: ");
            String pass = scanner.nextLine();
            boolean ischaracter = false, isnumber = false, isspecial = false;
            if (pass.length() < 8) {
                System.out.println("weak...");
                return;
            }
            for (int i = 0; i < pass.length(); i++) {
                if (Character.isDigit(pass.charAt(i))) {
                    isnumber = true;
                } else if (Character.isLetter(pass.charAt(i))) {
                    ischaracter = true;
                } else if (!Character.isLetterOrDigit(i)) {
                    isspecial = true;
                }
            }
            if (isnumber && ischaracter && isspecial) {
                System.out.println("Strong...");
            } else if (isnumber && ischaracter || isnumber && isspecial || ischaracter &&
                    isspecial) {
                System.out.println("Good...");
            } else if (isnumber || ischaracter || isspecial) {
                System.out.println("Medium...");
            }
        }
    }
}

// int count =
// 0;if(isnumber)count++;if(ischaracter)count++;if(isspecial)count++;switch(count)
// {
// case 1:
// System.out.println("Medium...");
// break;
// case 2:
// System.out.println("Good...");
// break;
// case 3:
// System.out.println("Strong...");
// break;
// }