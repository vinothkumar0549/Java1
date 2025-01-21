public class Q25RightLeaderElement {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        int[] arr = { 12, 5, 5, 3, 11, 2, 1 };
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                builder.insert(0, arr[i]);
                max = arr[i];
            }
        }
        System.out.println(builder.toString());
    }
}
