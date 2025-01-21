import java.util.Stack;

public class ExpressionEvaluation {
    public static void main(String[] args) {
        String input = "((2*1*6))/2";
        System.out.println(checkExpression(input));
    }

    static double checkExpression(String input) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == ' ') {
                continue;
            }
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                StringBuilder builder = new StringBuilder();
                while (i < input.length() && (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.')) {
                    builder.append(input.charAt(i));
                    i++;
                }
                values.push(Double.parseDouble(builder.toString()));
                i--;
            } else if (input.charAt(i) == '(') {
                operators.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperators(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'
                    || input.charAt(i) == '/') {
                while (!operators.isEmpty() && hasprecedence(input.charAt(i), operators.peek())) {
                    values.push(applyOperators(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(input.charAt(i));
            }
        }
        while (!operators.isEmpty()) {
            values.push(applyOperators(operators.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }

    static boolean hasprecedence(char operator1, char operator2) {
        if (operator2 == '(' || operator2 == ')')
            return false;
        if ((operator1 == '/' || operator1 == '*') && (operator2 == '+' || operator2 == '-')) {
            return false;
        }
        return true;
    }

    static double applyOperators(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand2 + operand1;
            case '-':
                return operand2 - operand1;
            case '*':
                return operand2 * operand1;
            case '/':
                if (operand1 == 0)
                    throw new ArithmeticException("Divide by Zere");
                return operand2 / operand1;
        }
        return 0;
    }
}
