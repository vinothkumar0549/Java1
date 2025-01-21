import java.util.Scanner;

public class Q3PatternStar {
    public static void main(String[] args) {
        String[] arr = { "abc", "def", "ghi" };
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < arr.length + ((n - arr.length) * 2); i++) {
            for (int j = 0; j < arr.length + 2; j++) {
                if (i < n - arr.length || i > (n - arr.length) + arr.length - 1) {
                    System.out.print("*");

                } else if (j == 0 || j == arr.length + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(arr[i - (n - arr.length)]);
                    j = arr.length;
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
