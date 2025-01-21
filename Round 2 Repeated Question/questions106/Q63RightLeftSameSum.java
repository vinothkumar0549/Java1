package questions106;

public class Q63RightLeftSameSum {
    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int leftSum = 0, rightSum = 0;

        for (int num : arr) {
            rightSum += num;
        }
        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                System.out.println("The equilibrium index is " + i + " with the number " + arr[i]);
                return;
            }
            leftSum += arr[i];
        }

        System.out.println("No equilibrium index found");
    }
}
