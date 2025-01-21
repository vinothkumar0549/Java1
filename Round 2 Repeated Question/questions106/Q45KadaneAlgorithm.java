package questions106;

public class Q45KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = { -2, 7, 5, -1, 3, 2, 9, -7 };
        int currmax = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currmax = currmax + arr[i];
            // if (arr[i] < 0) { Not Negative Elements Contians
            // currmax = 0;
            // }
            if (currmax > max) {
                max = currmax;
            }
            if (currmax < 0) {
                currmax = 0;
            }
        }
        System.out.println(max);
    }
}
