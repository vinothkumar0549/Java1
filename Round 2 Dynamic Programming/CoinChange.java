public class CoinChange {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 3, 4 };
        int n = coins.length;
        int sum = 5;

        int coinchangeways = findCoinChange(coins, n, sum);
        System.out.println(coinchangeways);

    }

    public static int findCoinChange(int[] coins, int n, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[sum];
    }
}