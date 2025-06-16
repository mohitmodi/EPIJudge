package educative;

class CheckSort {
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
//[-870,-550,-450,450,550,870]
        //[550, -550, 870, -870, 450, -450]
        Stack<Integer> result = new Stack<>(stack.getMaxSize());
        Stack<Integer> result2 = new Stack<>(stack.getMaxSize());

        while (!stack.isEmpty()) {
            if (result.isEmpty() && result2.isEmpty()) {
                result2.push(stack.pop());
            } else if (stack.top() > result2.top()) {
                while (!result.isEmpty() && stack.top() > result.top()){
                    result2.push(result.pop());
                }
                result2.push(stack.pop());
            } else {
                while (!result2.isEmpty() && stack.top() < result2.top()) {
                    result.push(result2.pop());
                }
                result2.push(stack.pop());
            }
        }
        while (!result.isEmpty()) {
            result2.push(result.pop());
        }

        while (!result2.isEmpty()) {
            result.push(result2.pop());
        }


        return result;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {550, -550, 870, -870, 450, -450}
        };

        for (int[] stackValues : inputs) {
            Stack<Integer> stack = new Stack<>(stackValues.length);
            for (int value : stackValues) {
                stack.push(value);
            }
            System.out.print("Original Stack: [");
            for (int i = 0; i < stackValues.length; i++) {
                System.out.print(stackValues[i]);
                if (i < stackValues.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            Stack<Integer> sortedStack = sortStack(stack);
            System.out.print("Sorted Stack: [");
            while (!sortedStack.isEmpty()) {
                System.out.print(sortedStack.pop());
                if (!sortedStack.isEmpty()) {
                    System.out.print(", ");
                }
            }
            System.out.println("]\n" + new String(new char[75]).replace('\0', '-'));
        }
    }

}

class Stack<V> {
    private int maxSize;
    private int top;
    private V[] array;
    private int currentSize;

    /*
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Comment out the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Stack(int max_size) {
        this.maxSize = max_size;
        this.top = -1; //initially when stack is empty
        array = (V[]) new Object[max_size]; //type casting Object[] to V[]
        this.currentSize = 0;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    //returns the maximum size capacity
    public int getMaxSize() {
        return maxSize;
    }

    //returns true if Stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    //returns true if Stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //returns the value at top of Stack
    public V top() {
        if (isEmpty())
            return null;
        return array[top];
    }

    //inserts a value to the top of Stack
    public void push(V value) {
        if (isFull()) {
            System.err.println("Stack is Full!");
            return;
        }
        array[++top] = value; //increments the top and adds value to updated top
        currentSize++;
    }

    //removes a value from top of Stack and returns
    public V pop() {
        if (isEmpty())
            return null;
        currentSize--;
        return array[top--]; //returns value and top and decrements the top
    }
}