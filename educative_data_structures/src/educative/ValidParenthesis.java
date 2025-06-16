package educative;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis {
    public static boolean validParentheses(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>(s.length());
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            if (map.containsKey(currChar)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.top().equals(map.get(currChar))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            } else {
                stack.push(currChar);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{}[]{}[{}])";
        System.out.println(validParentheses(s));
    }
}
