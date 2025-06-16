package educative;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Given a string, s, that may have matched and unmatched parentheses,
// remove the minimum number of parentheses so that the resulting string represents a valid parenthesization.
// For example, the string “a(b)” represents a valid parenthesization while the string
// “a(b” doesn’t, since the opening parenthesis doesn’t have any corresponding closing parenthesis.
public class ValidParethesis2 {
    public static String minRemoveParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(') {
                //Parenthesis paren = new Parenthesis(i, currChar);
                stack.push(i);
                str.append(currChar);
            } else if (currChar == ')') {
                if (stack.isEmpty()) {
                    str.append("0");
                } else {
                    stack.pop();
                    str.append(currChar);
                }
            } else {
                str.append(currChar);
            }
        }
        while (!stack.isEmpty()) {
            str.deleteCharAt(stack.pop());
        }
        return str.toString().
                replace('0',' ').
                replaceAll("\\s+","");
    }

    public static void main(String[] args) {

        List<String> inputs = Arrays.asList("())((())(()(()))()()())((()))))()(())())((((()(()()(())(())(");
        for (int i = 0; i < inputs.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ". Input: " + inputs.get(i));
            System.out.println("   Valid parentheses, after minimum removal: "
                    + minRemoveParentheses(inputs.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

class Parenthesis {
    int index;
    Character character;

    Parenthesis(int index, Character character) {
        this.index = index;
        this.character = character;

    }
}