package questions106;

public class Q94ContainsSumSubArray {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 8, 10 };
        int n = 7;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == n) {
                System.out.println("True");
                return;
            } else if (sum < n) {
                left++;
            } else {
                right--;
            }
        }
    }
}