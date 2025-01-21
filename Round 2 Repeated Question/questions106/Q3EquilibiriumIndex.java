package questions106;

public class Q3EquilibiriumIndex {
    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int n = arr.length, left = 0, right = 0, pivot = 0;
        for (int i = 1; i < n; i++) {
            right += arr[i];
        }
        while (pivot < n - 1 && right != left) {
            pivot++;
            right -= arr[pivot];
            left += arr[pivot - 1];
        }
        int result = (right == left) ? pivot : -1;
        System.out.println("The Equibilirium Index: " + result);
    }
}
