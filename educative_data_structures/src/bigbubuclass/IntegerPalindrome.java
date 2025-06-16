package bigbubuclass;

public class IntegerPalindrome {
    //Write a program that checks whether an integer is a palindrome.
    // For example, 121 is a palindrome, as well as 888. 678 is not a palindrome. Do not convert the integer into a string.

    public static void main(String[] args) {
        int input = 123321;
        System.out.println(isPanindrome(input));
    }

    private static boolean isPanindrome(int input) {
        int ans = 0;
        int num = input;
        while (num / 10 != 0) {
            ans = ans * 10 + num % 10;
            num = num / 10;
        }
        ans = ans * 10 + num % 10;
        return ans == input;
    }
}
