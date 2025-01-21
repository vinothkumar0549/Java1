package questions13;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q7JumbleSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                map.put(num, builder.toString());
                builder.setLength(0);
            } else if (Character.isDigit(input.charAt(i))) {
                num = Character.getNumericValue(input.charAt(i));
            } else {
                builder.append(input.charAt(i));
            }
        }
        map.put(num, builder.toString());
        builder.replace(0, builder.length(), "");

        String[] words = new String[map.size()];

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            words[e.getKey()] = e.getValue();
        }

        for (String w : words) {
            builder.append(w + " ");
        }

        System.out.println(builder.toString());
        scanner.close();
    }
}
