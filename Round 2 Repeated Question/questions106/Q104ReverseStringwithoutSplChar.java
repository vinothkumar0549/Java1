package questions106;

public class Q104ReverseStringwithoutSplChar {
    public static void main(String[] args) {
        String value = "house no : 123@ cbe";
        char[] arr = value.toCharArray();
        int i = 0, j = value.length() - 1;
        while (i < j) {
            while ((i < j) && !Character.isLetterOrDigit(arr[i])) {
                i++;
            }
            while ((i < j) && !Character.isLetterOrDigit(arr[j])) {
                j--;
            }
            if (Character.isLetterOrDigit(arr[i]) && Character.isLetterOrDigit(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        System.out.print(String.valueOf(arr));
    }
}
