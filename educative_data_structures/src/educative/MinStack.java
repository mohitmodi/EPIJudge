package educative;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    MinStack() {
        this.stack = new Stack<>(100);
        this.minStack = new Stack<>(1000);
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            if (stack.top() < minStack.top()) {
                minStack.push(stack.top());
            } else {
                minStack.push(minStack.top());
            }
        }
    }
    public  int pop(){
        if(!stack.isEmpty()){
            minStack.pop();
            return stack.pop();
        }
        else{
            return -1;
        }
    }
    public int min(){
        return minStack.top();
    }

    }
