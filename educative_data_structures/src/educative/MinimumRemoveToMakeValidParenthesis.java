package educative;

public class MinimumRemoveToMakeValidParenthesis {
    public static String minimumRemoveToMakeValidParenthesis(String s) {
        //"ab)ca(so)(sc(s)("
        Stack<Integer> stack = new Stack<>(s.length() + 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(') {
                stack.push(i);
                sb.append(currChar);
            } else if (currChar == ')') {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        sb.append("0");
                    } else {
                        stack.pop();
                        sb.append(currChar);
                    }

                }
            } else {
                sb.append(currChar);
            }
        }
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString().replaceAll("0", "");
    }


    public static void main(String[] args) {
        String s = "()";
        System.out.println(minimumRemoveToMakeValidParenthesis(s));
    }
}
