import java.util.Scanner;

public class Q2ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        System.out.println("Enter the String , Rotation Type (L or R), No. of Times: ");
        String value = scanner.nextLine();
        String type = scanner.nextLine();
        int n = scanner.nextInt();
        System.out.println(value + type + n);
        if (type.equals("L")) {
            for (int i = n; i < value.length(); i++) {
                builder.append(value.charAt(i));
            }
            for (int i = 0; i < n; i++) {
                builder.append(value.charAt(i));
            }
            // builder.append(value.substring(n)).append(value.substring(0, n));
        } else {
            for (int i = value.length() - n; i < value.length(); i++) {
                builder.append(value.charAt(i));
            }
            for (int i = 0; i < value.length() - n; i++) {
                builder.append(value.charAt(i));
            }
            // builder.append(value.substring(value.length() - n)).append(value.substring(0,
            // value.length() - n));
        }
        System.out.println(builder.toString());

        scanner.close();

    }
}
