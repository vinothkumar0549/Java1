package set1;

import java.util.Scanner;

public class Q6CricketScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Score TimeLine (W) wide, (.) Dot Ball, (N) No Ball (1-6) Score: ");
        String input = scanner.nextLine();
        System.out.println(input);
        int p1 = 0, p2 = 0, extraxs = 0;
        boolean play1 = true;
        for (int i = 0; i < input.length(); i++) {
            if (checkextras(input.charAt(i))) {
                extraxs++;
            } else if (Character.isDigit(input.charAt(i))) {
                if (play1) {
                    p1 += Character.getNumericValue(input.charAt(i));
                } else {
                    p2 += Character.getNumericValue(input.charAt(i));
                }
                if (Character.getNumericValue(input.charAt(i)) % 2 != 0) {
                    play1 = !play1;
                }
            }
        }
        System.out.println("Player 1: " + p1 + "\nPlayer 2: " + p2 + "\nExtras: " + extraxs);
        scanner.close();
    }

    static boolean checkextras(char c) {
        return "wnWN".indexOf(c) != -1;
    }
}

// package set1;

// import java.util.Scanner;

// public class Q6CricketScores {
// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// System.out.println("Enter the Score TimeLine (W) wide, (.) Dot Ball, (N) No
// Ball (1-6) Score: ");
// String input = scanner.nextLine();
// System.out.println(input);
// int p1 = 0, p2 = 0, extraxs = 0;
// boolean play1 = true;
// for (char c : input.toCharArray()) {
// if (checkextras(c)) {
// extraxs++;
// } else if (Character.isDigit(c)) {
// if (play1) {
// p1 += Character.getNumericValue(c);
// } else {
// p2 += Character.getNumericValue(c);
// }
// if (Character.getNumericValue(c) % 2 != 0) {
// play1 = !play1;
// }
// }
// }
// System.out.println("Player 1: " + p1 + "\nPlayer 2: " + p2 + "\nExtras: " +
// extraxs);
// scanner.close();
// }

// static boolean checkextras(char c) {
// return "wnWN".indexOf(c) != -1;
// }
// }
