package stacksandqueues;

public class SortStack {
    public static void insert(Stack < Integer > stack, int value) {
        if (stack.isEmpty() || value < stack.top())
            stack.push(value);
        else {
            int temp = stack.pop();
            insert(stack, value);
            stack.push(temp);
        }
    }

    public static Stack < Integer > sortStack(Stack < Integer > stack) {
        if (!stack.isEmpty()) {
            int value = stack.pop();
            sortStack(stack);
            insert(stack, value);
        }
        return stack;
    }

    public static Stack < Integer > sortStackIterative(Stack < Integer > stack) {
        //1. Use a second tempStack.
        //2. Pop value from mainStack.
        //3. If the value is greater or equal to the top of tempStack, then push the value in tempStack
        //else pop all values from tempStack and push them in mainStack and in the end push value in tempStack and repeat from step 2.
        //till mainStack is not empty.
        //4. When mainStack will be empty, tempStack will have sorted values in descending order.
        //5. Now transfer values from tempStack to mainStack to make values sorted in ascending order.
        Stack < Integer > newStack = new Stack < > (stack.getMaxSize());
        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            if (!newStack.isEmpty() && value >= newStack.top()) {
                newStack.push(value);
            } else {
                while (!newStack.isEmpty() && newStack.top() > value)
                    stack.push(newStack.pop());
                newStack.push(value);
            }
        }
        while (!newStack.isEmpty())
            stack.push(newStack.pop());

        return stack;
    }

    public static void main(String args[]) {

        Stack < Integer > stack = new Stack < Integer > (7);
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);
        stack = sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
