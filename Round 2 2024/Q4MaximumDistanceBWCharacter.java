import java.util.Arrays;

public class Q4MaximumDistanceBWCharacter {
    public static void main(String[] args) {
        String val = "abacdeefghdei";
        int maxdistance = -1;
        int[] lastseen = new int[26];
        Arrays.fill(lastseen, -1);

        int distance;
        for (int i = 0; i < val.length(); i++) {
            if (lastseen[val.charAt(i) - 'a'] != -1) {
                distance = i - lastseen[val.charAt(i) - 'a'];
                if (distance > maxdistance) {
                    maxdistance = distance;
                }
            }
            lastseen[val.charAt(i) - 'a'] = i;
        }

        if (maxdistance == -1) {
            System.out.println("No Repeated Letter...");
        } else {
            System.out.println("The Maximum Distance: " + (maxdistance - 1));
        }
    }
}

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.HashMap;

// public class Q4MaximumDistanceBWCharacter {
// public static void main(String[] args) {
// String input = "anbacdefgi";
// HashMap<Character, Integer> map = new HashMap<>();
// ArrayList<Integer> list = new ArrayList<>();
// int var;
// for (int i = 0; i < input.length(); i++) {
// if (map.containsKey(input.charAt(i))) {
// System.out.println("Not New");
// var = i - map.get(input.charAt(i)) - 1;
// list.add(var);
// map.put(input.charAt(i), i);
// } else {
// System.out.println("new");
// map.put(input.charAt(i), i);
// }
// }
// int max = Collections.max(list);// Collections.min(list) -- for minimum
// distance between character
// System.out.println(max);

// }
// }
