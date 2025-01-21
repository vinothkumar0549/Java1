import java.util.List;

public class SentenceBreakInDictionaray {
    public static void main(String[] args) {
        List<String> wordlist = List.of("i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango");
        String input = "ilikesamsung";

        System.out.println(breakSentence(wordlist, input));

    }

    static boolean breakSentence(List<String> wordlist, String input) {
        boolean dp[] = new boolean[input.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordlist.contains(input.substring(j, i))) {
                    if (dp[j] && breakSentence(wordlist, input.substring(i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[input.length()];
    }
}
