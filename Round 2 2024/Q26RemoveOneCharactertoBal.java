import java.util.HashMap;

public class Q26RemoveOneCharactertoBal {
    public static void main(String[] args) {
        String val = "aaaabbbbccc";
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : val.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        HashMap<Integer, Integer> countfreq = new HashMap<>();

        for (int i : freq.values()) {
            countfreq.put(i, countfreq.getOrDefault(i, 0) + 1);
        }

        if (countfreq.size() == 1) {
            System.out.println("Already all the Character have Same Frequency...");
        } else if (countfreq.size() == 2) {
            Integer[] arr = countfreq.keySet().toArray(new Integer[0]);
            int freq1 = arr[0];
            int freq2 = arr[1];
            int count1 = countfreq.get(freq1);
            int count2 = countfreq.get(freq2);

            if ((freq1 == 1 && count1 == 1) || (freq2 == 1 || count2 == 1)) {
                System.out.println("Balancing...");
                return;
            } else if (Math.abs(freq1 - freq2) == 1 && (count1 == 1 && count2 == 1)) {
                System.out.println("Balancing...");
                return;
            }
            System.out.println("Not Balancing...");
        } else {
            System.out.println("Not Balacing...");
        }
    }
}
