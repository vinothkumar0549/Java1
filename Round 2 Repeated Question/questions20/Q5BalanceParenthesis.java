package questions20;

import java.util.Scanner;
import java.util.ArrayList;

public class Q5BalanceParenthesis {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the parenthesis: ");
            String p = scanner.nextLine();
            ArrayList<Character> list = new ArrayList<>();

            for (char c : p.toCharArray()) {
                if (c == '(') {
                    list.add(c);
                } else {
                    if (list.size() == 0) {
                        System.out.println("Not Balanced");
                        return;
                    }
                    if (list.get(list.size() - 1) == '(') {
                        list.remove(list.size() - 1);
                    } else {
                        list.add(c);
                    }
                }
            }
            System.out.println(list.size());
            if (list.isEmpty()) {
                System.err.println("Balance");
            } else {
                System.out.println("Not Balance");
            }
        }
    }
}
