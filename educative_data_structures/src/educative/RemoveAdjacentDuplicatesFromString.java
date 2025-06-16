package educative;

import java.util.Stack;

public class RemoveAdjacentDuplicatesFromString {
    public static String removeDuplicates(String s) {

        StringBuilder sb=new StringBuilder();

        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }

        System.out.println(sb.reverse().toString());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        removeDuplicates("ggaabcdeb");
    }

}
