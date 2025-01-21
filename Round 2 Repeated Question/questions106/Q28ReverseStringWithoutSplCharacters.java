package questions106;

//import java.util.Arrays;

public class Q28ReverseStringWithoutSplCharacters {
    public static void main(String[] args) {
        String value = "house no : 123@ cbe";
        char[] arr = value.toCharArray();
        int i = 0, j = value.length() - 1;
        char temp;

        while (i < j) {
            while ((i < j) && !Character.isLetterOrDigit(arr[i])) {
                i++;
            }
            while ((i < j) && !Character.isLetterOrDigit(arr[j])) {
                j--;
            }
            if (Character.isLetterOrDigit(arr[i]) && Character.isLetterOrDigit(arr[j])) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        System.out.println(String.valueOf(arr));
    }
}

// public class ReverseStringWithoutSplCharacters {
// public static void main(String[] args) {
// String value = "house no : 123@ cbe";
// char[] arr = value.toCharArray();
// int i = 0, j = value.length() - 1;
// char temp;

// while (i < j) {
// if ((Character.isLetter(arr[i]) || Character.isDigit(arr[i]))
// && (Character.isLetter(arr[j]) || Character.isDigit(arr[j]))) {
// temp = arr[i];
// arr[i] = arr[j];
// arr[j] = temp;
// i++;
// j--;
// } else if (Character.isLetter(arr[i]) || Character.isDigit(arr[i])) {
// j--;
// } else if (Character.isLetter(arr[j]) || Character.isDigit(arr[j])) {
// i++;
// }
// }
// System.out.println(String.valueOf(arr));
// }
// }
