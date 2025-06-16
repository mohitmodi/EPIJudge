package educative;

public class AdjacentDuplicateInAString {
    public static String removeAdjacentDuplicate(String s) {
        Stack<Character> stack = new Stack<>(s.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.top() == s.charAt(i)) {
                stack.pop();
                stack.push(s.charAt(i));
            } else {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
