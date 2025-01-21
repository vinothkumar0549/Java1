package questions106;

public class Q81PrintOddEvenCount {
    public static void main(String[] args) {
        int num = 1234567;

        int temp, even = 0, odd = 0;
        while (num > 0) {
            temp = num % 10;
            if (temp % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            num = num / 10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
