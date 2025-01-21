package questions106;

public class Q83PascalTriangle {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + factorial(i) / ((factorial(i - j)) * (factorial(j))));
            }
            System.out.println();
        }
    }

    static int factorial(int i) {
        if (i == 0) {
            return 1;
        }
        return i * factorial(i - 1);
    }
}
