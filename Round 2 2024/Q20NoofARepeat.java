// public class Q20NoofARepeat {
//     public static void main(String[] args) {
//         String input = "abcac";
//         int n = 10;
//         int count = 0;
//         for (char c : input.toCharArray()) {
//             if (c == 'a') {
//                 count++;
//             }
//         }
//         double multiplier = Math.ceil(count * (double) n / input.length());
//         System.out.println(multiplier);
//     }
// }

public class Q20NoofARepeat {
    public static void main(String[] args) {
        String input = "aba";
        int n = 10;
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }
        int repetitions = n / input.length();
        int full_count = repetitions * count;
        System.out.println(full_count);
        int remainder = n % input.length();
        int remainder_count = 0;
        for (int i = 0; i < remainder; i++) {
            if (input.charAt(i) == 'a') {
                remainder_count++;
            }
        }

        // Total 'a' count
        int total_count = full_count + remainder_count;
        System.out.println(total_count);
    }
}
