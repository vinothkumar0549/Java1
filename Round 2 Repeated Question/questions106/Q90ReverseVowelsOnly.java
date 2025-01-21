package questions106;

public class Q90ReverseVowelsOnly {
    public static void main(String[] args) {
        String value = "Vinothkumar";
        char arr[] = value.toCharArray();
        int l = 0, r = arr.length - 1;

        while (l < r) {
            while ((l < r) && (vowelcheck(arr[l]) == -1)) {
                l++;
            }
            while ((l < r) && (vowelcheck(arr[r]) == -1)) {
                r--;
            }
            if (l < r) {
                char temp = arr[l];
                arr[l++] = arr[r];
                arr[r--] = temp;
            }
        }
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }

    static int vowelcheck(char c) {
        return "aeiouAeiou".indexOf(c);
    }
}
