import java.util.Stack;

public class ParenthesisCheck {
    public static void main(String[] args) {
        String input = "((()())(){})";
        System.out.println(checkParenthesis(input));
    }

    static boolean checkParenthesis(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                stack.push(input.charAt(i));
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char check = stack.pop();
            if (check == '(' && input.charAt(i) != ')') {
                return false;
            } else if (check == '{' && input.charAt(i) != '}') {
                return false;
            } else if (check == '[' && input.charAt(i) != ']') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
