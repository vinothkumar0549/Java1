import java.util.Scanner;

public class Q23StackResize {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the Size of the Three Stacks: ");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        int[] s1 = createstack(n1);
        int[] s2 = createstack(n2);
        int[] s3 = createstack(n3);

        System.out.println("The Same Maximum height: " + samestacksize(s1, s2, s3));
    }

    static int samestacksize(int[] s1, int[] s2, int[] s3) {
        int height1 = sum(s1);
        int height2 = sum(s2);
        int height3 = sum(s3);

        int index1 = 0, index2 = 0, index3 = 0;

        while (!((height1 == height2) && (height2 == height3))) {
            if (height1 > height2 && height1 > height3) {
                height1 -= s1[index1++];
            } else if (height2 > height1 && height2 > height3) {
                height2 -= s2[index2++];
            } else {
                height3 -= s3[index3++];
            }
        }
        return height1;
    }

    static int sum(int[] s) {
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            sum += s[i];
        }
        return sum;
    }

    static int[] createstack(int n) {
        int[] s = new int[n];
        // for (int i = n - 1; i >= 0; i--) {
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }
        return s;
    }
}
