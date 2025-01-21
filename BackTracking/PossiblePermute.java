public class PossiblePermute {

    public static void main(String[] args) {
        String input = "imimc";
        printPossiblePermute(input, "");
    }

    static void printPossiblePermute(String input, String prefix) {
        int n = input.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                char ch = input.charAt(i);
                String remain = input.substring(0, i) + input.substring(i + 1, n);
                printPossiblePermute(remain, prefix + ch);
            }
        }
    }
}
