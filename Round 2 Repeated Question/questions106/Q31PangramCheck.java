// package questions106;

// import java.util.Scanner;

// public class Q31PanagramCheck {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Enter the String: ");
//         String value = scanner.nextLine();
//         boolean ispanagram = true;
//         for (char c = 'a'; c <= 'z'; c++) {
//             if (!value.contains(String.valueOf(c))) {
//                 ispanagram = false;
//                 break;
//             }
//         }
//         if (ispanagram) {
//             System.out.println("Panagram...");
//         } else {
//             System.out.println("Not Panagram...");
//         }
//         scanner.close();
//     }
// }

package questions106;

import java.util.Scanner;

public class Q31PangramCheck {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the String: ");
            String value = scanner.nextLine();
            boolean[] pangaram = new boolean[26];
            for (int i = 0; i < value.length(); i++) {
                int letter = value.charAt(i) - 'a';
                pangaram[letter] = true;
            }
            for (boolean b : pangaram) {
                if (!b) {
                    System.out.println("Not Panagram...");
                    return;
                }
            }
            System.out.println("Panagram...");
        }
    }
}