package questions106;

import java.util.Scanner;

public class Q16InfinitieGridPosition {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the Position in x and y: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the Direction: ");
            String direction = scanner.nextLine();
            for (char c : direction.toCharArray()) {
                if (c == 'L' || c == 'l') {
                    x -= 1;
                } else if (c == 'R' || c == 'r') {
                    x += 1;
                } else if (c == 'U' || c == 'u') {
                    y += 1;
                } else if (c == 'D' || c == 'd') {
                    y -= 1;
                }
            }
            System.out.println("The Current Position: " + x + " " + y);
        }
    }
}

// package questions106;

// import java.util.Scanner;

// public class Q16InfinitieGridPosition {
// public static void main(String[] args) {
// try (Scanner scanner = new Scanner(System.in)) {
// System.out.println("Enter the Position in x and y: ");
// int x = scanner.nextInt();
// int y = scanner.nextInt();
// System.out.println("Enter the No. of the Direction: ");
// int n = scanner.nextInt();
// char[] arr = new char[n];
// System.out.println("Enter the Direction (L or R or U or D): ");
// for (int i = 0; i < n; i++) {
// arr[i] = scanner.next().charAt(0);
// }
// for (char c : arr) {
// if (c == 'L' || c == 'l') {
// x -= 1;
// } else if (c == 'R' || c == 'r') {
// x += 1;
// } else if (c == 'U' || c == 'u') {
// y += 1;
// } else if (c == 'D' || c == 'd') {
// y -= 1;
// }
// }
// System.out.println("The Current Position: " + x + " " + y);
// }
// }
// }
