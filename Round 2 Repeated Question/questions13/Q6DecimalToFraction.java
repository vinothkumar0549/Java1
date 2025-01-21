package questions13;

import java.util.Scanner;

public class Q6DecimalToFraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        double number = scanner.nextDouble();
        convertDecimalToFraction(number);
        scanner.close();
    }

    static void convertDecimalToFraction(double number) {
        int integralpart = (int) number;
        float decimalpart = (float) (number - integralpart);

        if (decimalpart == 0) {
            System.out.println(integralpart);
            return;
        }
        int denominator = 1;
        while ((decimalpart * denominator) % 1 != 0) {
            denominator *= 10;
        }
        int numerator = (int) Math.round(decimalpart * denominator);
        int gcd = convertgcd(numerator, denominator);
        // System.out.println(gcd + " " + numerator + " " + denominator);

        numerator = numerator / gcd;
        denominator = denominator / gcd;

        if (integralpart != 0) {
            System.out.println(integralpart + " " + numerator + "/" + denominator);
        } else {
            System.out.println(numerator + "/" + denominator);
        }
    }

    static int convertgcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return convertgcd(b, a % b);
    }
}