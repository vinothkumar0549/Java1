import java.util.ArrayList;

public class PrintCoinChange {
    static int count = 0;

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3, 4 };
        int n = coins.length;
        int sum = 5;

        ArrayList<Integer> coinchanges = new ArrayList<>();
        coinChangePrint(coins, n, sum, 0, coinchanges);
        System.out.println("The Total Combination: " + count);
    }

    public static void coinChangePrint(int[] coins, int n, int sum, int start, ArrayList<Integer> coinchanges) {
        if (sum == 0) {
            System.out.println(coinchanges);
            count++;
            return;
        }
        for (int i = start; i < n; i++) {
            if (sum >= coins[i]) {
                coinchanges.add(coins[i]);
                coinChangePrint(coins, n, sum - coins[i], i, coinchanges); // Print all Combination
                // coinChangePrint(coins, n, sum - coins[i], i + 1, coinchanges);//printDistinct
                coinchanges.remove(coinchanges.size() - 1);
            }
        }
        return;
    }

}
