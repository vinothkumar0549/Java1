import java.util.ArrayList;
import java.util.HashMap;

public class Q7MaximumDistanceBWCharacter {
    public static void main(String[] args) {
        String input = "vinothkumavr";
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        int var;
        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(input.charAt(i))) {
                var = i - map.get(input.charAt(i)) - 1;
                if (var > list.get(0)) {
                    list.remove(0);
                    list.add(var);
                }
                map.put(input.charAt(i), i);
            } else {
                map.put(input.charAt(i), i);
            }
        }
        System.out.println(list.get(0));
    }
}
