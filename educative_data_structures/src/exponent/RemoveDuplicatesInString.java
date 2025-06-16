package exponent;

import java.util.Stack;

public class RemoveDuplicatesInString {

    public static String identifyAdjacent(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.get(stack.size() - 1).character == c) {
                stack.get(stack.size() - 1).count++; // Increment the count of the top element if it's the same character
            } else {
                stack.add(new Pair(c, 1)); // Push a new character with count 1 onto the stack
            }
            if (stack.get(stack.size() - 1).count == k) {
                stack.remove(stack.size() - 1); // Remove the top element if its count reaches k
            }
        }

        StringBuilder result = new StringBuilder(); // StringBuilder for efficient string construction
        for (Pair pair : stack) {
            for (int i = 0; i < pair.count; i++) {
                result.append(pair.character); // Append each character count times
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // debug your code below
        System.out.println(identifyAdjacent("daaabbbaa", 3));
    }
}

class Pair {
    int count;
    char character;

    Pair(char character, int count) {
        this.count = count;
        this.character = character;
    }
}
