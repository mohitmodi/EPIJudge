package bigbubuclass;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> addStack = new Stack<>();
        while (!stack.isEmpty()) {
            addStack.push(stack.pop());
        }
        while (!addStack.isEmpty()) {
            if (stack.isEmpty()) {
                stack.push(addStack.pop());
            }
            int curr = addStack.pop();
            if (stack.peek() > curr) {
                stack.push(curr);
            } else {
                while (!stack.isEmpty() && stack.peek() < curr) {
                    addStack.push(stack.pop());
                }
                stack.push(curr);
            }
        }
        return stack;
    }
}
