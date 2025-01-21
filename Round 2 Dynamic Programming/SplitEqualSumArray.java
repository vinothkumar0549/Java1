import java.util.ArrayList;

public class SplitEqualSumArray {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 6, 2 };
        int sum = sum(arr);
        if (sum % 2 != 0) {
            System.out.println("Not Possible to Split...");
            return;
        }
        ArrayList<Integer> firstarray = new ArrayList<>();
        if (splitEqualSumSubArray(arr, arr.length, sum / 2, 0, firstarray)) {
            System.out.println("First Sub Array: ");
            System.out.println(firstarray);
            // printSubArray(firstarray.stream().mapToInt(i -> i).toArray());
            // Using Stream convert from List<Integer> to int[] array
            System.out.println("Second Sub Array: ");
            findSecondArray(arr, firstarray);
        } else {
            System.out.println("Not Possible");
        }

    }

    public static boolean splitEqualSumSubArray(int[] arr, int n, int sum, int start, ArrayList<Integer> combination) {
        if (sum == 0) {
            // System.out.println(combination);
            return true;
        }
        for (int i = start; i < n; i++) {
            if (sum >= arr[i]) {
                combination.add(arr[i]);
                if (splitEqualSumSubArray(arr, n, sum - arr[i], i + 1, combination)) {
                    return true;
                }
                combination.remove(combination.size() - 1);
            }
        }
        return false;
    }

    public static void printSubArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void findSecondArray(int[] arr, ArrayList<Integer> firstarray) {
        ArrayList<Integer> secondarray = new ArrayList<>();
        for (int val : arr) {
            if (firstarray.contains(val)) {
                firstarray.remove((Integer) val); // always convert Integer for remove the element ortherwise it
                                                  // consider index
            } else {
                secondarray.add(val);
            }
        }
        System.out.println(secondarray);
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }
}
