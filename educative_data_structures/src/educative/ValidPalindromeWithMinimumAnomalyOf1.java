package educative;

public class ValidPalindromeWithMinimumAnomalyOf1 {
    public static boolean validPalindromeWithMinimumAnomalyOf1(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean replacementRequired = false;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (!replacementRequired) {
                replacementRequired = true;
                if (s.charAt(i + 1) == s.charAt(j))
                    i++;
                else {
                    j--;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyzWABCDEFEDCBAzyxwvutsrqponmlkjihgfedcba";
        System.out.println(validPalindromeWithMinimumAnomalyOf1(s));

    }
}
