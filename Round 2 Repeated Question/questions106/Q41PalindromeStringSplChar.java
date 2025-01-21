package questions106;

public class Q41PalindromeStringSplChar {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal, Panama";

        int i = 0, j = input.length() - 1;
        while (i < j) {
            while ((i < j) && !Character.isLetterOrDigit(input.charAt(i))) {
                i++;
            }
            while ((i < j) && !Character.isLetterOrDigit(input.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(input.charAt(i)) != Character.toLowerCase(input.charAt(j))) {
                System.out.println("Not Palindrome...");
                return;
            }
            i++;
            j--;
        }
        System.out.println("Palindrome...");
    }
}
