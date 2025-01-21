// package set5;

// import java.util.Scanner;

// public class Q6APresentInB {
//     public static void main(String[] args) {
//         try (Scanner scanner = new Scanner(System.in)) {
//             System.out.println("Enter the a and b: ");
//             int a = scanner.nextInt();
//             int b = scanner.nextInt();

//             int temp2 = a % 10;
//             while (b > 0) {
//                 int temp1 = b % 10;
//                 if (temp1 == temp2) {
//                     boolean val = apresentb(b, a);
//                     if (val) {
//                         System.out.println("True");
//                         return;
//                     }
//                 }
//                 b = b / 10;
//             }
//         }
//     }

//     static boolean apresentb(int b, int a) {
//         if (a == 0) {
//             return true;
//         } else if (b % 10 == a % 10) {
//             return apresentb(b / 10, a / 10);
//         } else {
//             return false;
//         }
//     }
// }

package set5;

import java.util.Scanner;

public class Q6APresentInB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values for a and b: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        boolean result = isAPresentInB(a, b);
        System.out.println(result ? "True" : "False");
    }

    static boolean isAPresentInB(int a, int b) {
        // Convert 'a' to a string to get its length
        String strA = Integer.toString(a);
        int lenA = strA.length();

        while (b > 0) {
            if (b % Math.pow(10, lenA) == a) {
                return true;
            }
            b = b / 10;
        }
        return false;
    }
}
