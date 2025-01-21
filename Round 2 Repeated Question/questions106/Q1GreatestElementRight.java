package questions106;

public class Q1GreatestElementRight {
    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = max;
            if (arr[i] > max) {
                max = arr[i];
            }
            arr[i] = temp;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
