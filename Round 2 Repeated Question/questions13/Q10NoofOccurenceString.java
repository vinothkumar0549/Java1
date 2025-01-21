package questions13;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Q10NoofOccurenceString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();
        System.out.println("Enter the String to Check: ");
        String str = scanner.nextLine();
        String Line;

        while ((Line = scanner.nextLine()) != "") {
            String[] words = Line.split(" ");
            int count = 0;
            for (String word : words) {
                if (word.equals(str)) {
                    count++;
                }
            }
            if (map.getOrDefault(count, null) != null) {
                map.get(count).add(Line);
            } else {
                map.put(count, new ArrayList<>(Arrays.asList(Line)));
            }
        }

        for (Map.Entry<Integer, ArrayList<String>> e : map.entrySet()) {
            for (String s : e.getValue()) {
                System.out.println(s);
            }
        }

        System.out.println(map);
        scanner.close();
    }
}
