public class PerumuteBitManinpulation {
    public static void main(String[] args) {
        String input = "123";
        int n = input.length();
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(input.charAt(j) + " ");
                }
            }
            System.out.println();
        }
    }
}
