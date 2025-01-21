package set3;

import java.util.ArrayList;
import java.util.Scanner;

public class Q3AnagramCheck1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String Line;
        System.out.println("Enter the String (Type exit to Stop): ");
        while (!(Line = scanner.nextLine()).equalsIgnoreCase("exit")) {
            list.add(Line);
        }
        System.out.println("Enter the String to Check: ");
        String word = scanner.nextLine();

        char[] letters = word.toCharArray();
        bubblesort(letters);
        String originalword = String.valueOf(letters);

        ArrayList<String> result = findAnagram(list, originalword);

        System.out.println(result);

        scanner.close();
    }

    static ArrayList<String> findAnagram(ArrayList<String> list, String originalword) {

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            char[] letters = word.toCharArray();
            bubblesort(letters);
            String newword = String.valueOf(letters);

            if (originalword.equals(newword)) {
                result.add(word);
            }
        }
        return result;
    }

    static void bubblesort(char[] letters) {
        int n = letters.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (letters[j] > letters[j + 1]) {
                    char temp = letters[j];
                    letters[j] = letters[j + 1];
                    letters[j + 1] = temp;
                    swap = true;
                }
            }
            if (swap == false) {
                break;
            }
        }
    }
}
