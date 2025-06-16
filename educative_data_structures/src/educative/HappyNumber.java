package educative;

import java.util.Map;

public class HappyNumber {
    public static boolean isHappyNumber(int n) {

        int slow = n;
        int fast = sumOfSquaredDigits(n);
        while (fast != 1 && slow != fast) {
            slow = sumOfSquaredDigits(slow);
            fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
            System.out.println(fast);
            System.out.println(slow);
            System.out.println("----");
        }
        return fast == 1;
    }

    private static int sumOfSquaredDigits(int number) {
        int totalSum = 0;
        while (number > 0) {
            int digit = number % 10;
            number = number / 10;
            totalSum += Math.pow(digit, 2);
        }
        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(4));
    }
}
