package questions106;

public class Q77PrintBinaryPattern {
    public static void main(String[] args) {
        int size = 4;

        for (int i = 0; i < Math.pow(2, size); i++) {
            char[] result = generatebinary(i, size);
            System.out.println(new String(result));
        }
    }

    static char[] generatebinary(int num, int size) {
        char[] binary = new char[size];
        for (int i = size - 1; i >= 0; i--) {
            if ((num & 1) == 1) {
                binary[i] = '1';
            } else {
                binary[i] = '0';
            }
            num >>= 1;
        }
        return binary;
    }
}

// package questions106;

// import java.util.Scanner;

// public class Q77PrintBinaryPattern {
// public static void main(String[] args) {
// try (Scanner scanner = new Scanner(System.in)) {
// int n = scanner.nextInt();

// for (int i = 0; i < Math.pow(2, n); i++) {
// String builder = "";
// builder = Integer.toBinaryString(i);
// while (n > builder.length()) {
// builder = "0" + builder;
// }
// System.out.println(builder.toString());
// }
// }
// }
// }
