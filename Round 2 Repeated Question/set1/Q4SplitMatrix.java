package set1;

public class Q4SplitMatrix {
    public static void main(String[] args) {
        // int[] arr[] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
        // 15, 16 } };
        int[] arr[] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int leftsum = 0, rightsum = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= arr.length - i - 1; j++) {
                // System.out.println(arr[i][j]);
                leftsum += arr[i][j];

            }
        }

        System.out.println("Top Left Sum: " + leftsum);

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= arr.length - 1 - i; j--) {
                // System.out.println(arr[i][j]);
                rightsum += arr[i][j];

            }
        }

        System.out.println("Bottom Right sum" + rightsum);

        if (leftsum > rightsum) {
            System.out.println("The Maximum Sum: " + leftsum);
        } else {
            System.out.println("The Maximum sum: " + rightsum);
        }
    }
}
