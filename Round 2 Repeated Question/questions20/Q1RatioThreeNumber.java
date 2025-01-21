package questions20;

public class Q1RatioThreeNumber {
    public static void main(String[] args) {
        int positive = 0, negative = 0, netural = 0;
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, -1, -2, -3, -4, -5, -6 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positive++;
            } else if (arr[i] < 0) {
                negative++;
            } else {
                netural++;
            }
        }

        int gcd = findGCD(positive, findGCD(negative, netural));
        System.out.println("The GCD: " + gcd);
        System.out.printf("The Ratio of the Positive : Negative : Netrual is- %d : %d : %d", positive / gcd,
                negative / gcd, netural / gcd);
    }

    static int findGCD(int x, int y) {
        if (y == 0) {
            return x;
        }
        return findGCD(y, x % y);
    }
}

// public class RatioThreeNumber {
// public static void main(String[] args) {
// int[] numbers = { 1, -2, 0, 4, -5, 0, 6, -3, 2, 0 };

// calculateAndPrintRatios(numbers);
// }

// public static void calculateAndPrintRatios(int[] numbers) {
// int total = numbers.length;
// int positiveCount = 0;
// int negativeCount = 0;
// int neutralCount = 0;

// for (int number : numbers) {
// if (number > 0) {
// positiveCount++;
// } else if (number < 0) {
// negativeCount++;
// } else {
// neutralCount++;
// }
// }

// double positiveRatio = (double) positiveCount / total;
// double negativeRatio = (double) negativeCount / total;
// double neutralRatio = (double) neutralCount / total;

// System.out.printf("Positive Ratio: %.2f\n", positiveRatio);
// System.out.printf("Negative Ratio: %.2f\n", negativeRatio);
// System.out.printf("Neutral Ratio: %.2f\n", neutralRatio);
// }
// }
