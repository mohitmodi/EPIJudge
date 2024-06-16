import java.util.Stack;

public class MinimumRemove {
    public static String minRemoveParentheses(String s) {
        StringBuilder sb=new StringBuilder(s);
        Stack<Integer> stack=new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')' && !stack.isEmpty()){
                stack.pop();
            }else if(s.charAt(i)==')' && stack.isEmpty()){
                sb.replace(i,i,"0");
            }
        }
        while(!stack.isEmpty()){
            sb.deleteCharAt(stack.pop());
        }


        return sb.toString().
                replace('0',' ').
                replaceAll("\\s+","");
    }

    public static void main(String[] args) {
        System.out.println(minRemoveParentheses("()"));
    }
}
