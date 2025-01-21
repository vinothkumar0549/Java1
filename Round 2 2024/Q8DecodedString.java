import java.util.Scanner;
import java.util.Stack;

public class Q8DecodedString {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            Stack<Integer> repeatcount = new Stack<>();
            Stack<String> strstack = new Stack<>();
            int index = 0;
            String result = "";

            while (index < input.length()) {
                if (Character.isDigit(input.charAt(index))) {
                    int count = 0;
                    while (Character.isDigit(input.charAt(index))) {
                        count = (count * 10) + (input.charAt(index) - '0');
                        index++;
                    }
                    repeatcount.push(count);
                } else if (input.charAt(index) == '[') {
                    strstack.push(result);
                    result = "";
                    index++;
                } else if (input.charAt(index) == ']') {
                    StringBuilder temp = new StringBuilder(strstack.pop());
                    int repeat = repeatcount.pop();
                    for (int i = 0; i < repeat; i++) {
                        temp.append(result);
                    }
                    result = temp.toString();
                    index++;
                } else {
                    result += input.charAt(index);
                    index++;
                }
            }
            System.out.println(result);
        }
    }
}
