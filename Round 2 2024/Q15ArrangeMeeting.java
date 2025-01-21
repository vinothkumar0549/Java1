import java.util.Scanner;

public class Q15ArrangeMeeting {
    public static void main(String[] args) {
        int end = 0;
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        System.out.println("Enter the Size of the Array: ");
        int n = scanner.nextInt();
        int[] s = new int[n], f = new int[n];

        System.out.println("Enter the start and end time (x y): ");
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
            f[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (s[i] > end) {
                if (s[i] < f[i]) {
                    System.out.println(s[i] + " " + f[i]);
                    builder.append(i + 1);
                    end = f[i];
                }
            }
        }
        System.out.println(builder.toString());
        scanner.close();
    }
}
