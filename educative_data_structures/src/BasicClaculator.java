import java.util.Stack;

public class BasicClaculator {
    public static int calculator(String expression) {
        int result = 0;
        Stack<Character> stack = new Stack<Character>();
        for (char val : expression.toCharArray()) {
            if (val != ')') {
                stack.push(val);
            } else {
                while (stack.pop() != '(') {
                    int a = stack.pop();
                    char operator = stack.pop();
                    int b = stack.pop();
                    if (operator == '+') {
                        result += a + b;

                    } else {
                        result += a - b;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculator("(8+1)+(1-8-(2+1))"));
    }
}
