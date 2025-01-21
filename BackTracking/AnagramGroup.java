import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class AnagramGroup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String (Type Exit to Stop): ");
        ArrayList<String> list = new ArrayList<>();
        String Line;
        while (!(Line = scanner.nextLine()).equalsIgnoreCase("exit")) {
            list.add(Line);
        }
        // System.out.println(list);

        HashMap<String, List<String>> map = groupAnagram(list);
        System.err.print("[");
        for (String s : map.keySet()) {
            List<String> groupanagram = map.get(s);
            System.out.print(groupanagram);
        }
        System.out.println("]");

        scanner.close();
    }

    static HashMap<String, List<String>> groupAnagram(List<String> list) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            char[] letters = word.toCharArray();
            // Arrays.sort(letters);
            bubblesort(letters, letters.length);
            String newword = String.valueOf(letters);

            if (map.containsKey(newword)) {
                map.get(newword).add('"' + word + '"');
            } else {
                List<String> anagram = new ArrayList<>();
                anagram.add('"' + word + '"');
                map.put(newword, anagram);
            }
        }
        return map;
    }

    static void bubblesort(char[] letters, int n) {
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
        // System.out.println(String.valueOf(letters));
    }
}
