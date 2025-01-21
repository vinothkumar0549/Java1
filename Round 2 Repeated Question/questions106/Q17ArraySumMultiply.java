package questions106;

public class Q17ArraySumMultiply {
    public static void main(String[] args) {

        int[] arr = { 120, 24, 71, 10, 59, 13 };
        for (int num : arr) {
            int val, sum = 0, mul = 1;
            while (num > 0) {
                val = num % 10;
                sum += val;
                mul *= val;
                num = num / 10;
            }
            if (sum > mul) {
                System.out.print(sum + " ");
            } else {
                System.out.print(mul + " ");
            }
        }
    }
}
