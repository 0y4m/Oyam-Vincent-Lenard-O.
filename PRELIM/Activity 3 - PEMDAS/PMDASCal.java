import java.util.Scanner;
import java.util.Stack;

public class PMDASCal {
    private String expression;

    public PMDASCal() {
        this.expression = "";
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int evaluateExpression() {
        try {
            return evaluate(this.expression);
        } catch (Exception e) {
            System.out.println("Invalid expression: " + e.getMessage());
            return 0; 
        }
    }

    private int evaluate(String expression) {
        expression = expression.replaceAll("\\s+", "").trim();
        return evaluateExpression(expression);
    }

    private int evaluateExpression(String expression) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)))) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                i--;
                int number = Integer.parseInt(numBuilder.toString());
                numbers.push(number);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    private int applyOperator(char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                return 0;       }
    }

    public static void main(String[] args) {
        PMDASCal calculator = new PMDASCal();
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("  'Enter an expression' ");
        System.out.println("=========================");
        String expression = scanner.nextLine();
        calculator.setExpression(expression);

        int result = calculator.evaluateExpression();
        System.out.println("=========================");
        System.out.println("   Result = " + result);
        System.out.println("=========================");


        scanner.close();
    }
}