import java.util.Scanner;

public class Q10LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        String[] arr = new String[n];
        System.out.println("Enter the Elements in the Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        System.out.println("The Longest Common Prefix: " + longestcommonprefix(arr, n));
        scanner.close();
    }

    static String longestcommonprefix(String[] arr, int n) {
        String prefix = arr[0];

        for (int i = 1; i < n; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix == "") {
                    return "NO Common Prefix";
                }
            }
        }
        return prefix;
    }
}
