package bigbubuclass;

public class StringReversal {
    public static void main(String[] args) {
        String s = "haDrRAHdw";
        System.out.println(reversal(s));
    }

    private static boolean reversal(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() - 1 || right > 0) {
            while (left < s.length() && Character.isUpperCase(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && Character.isLowerCase(s.charAt(right))) {
                right--;
            }
            if (left < s.length() && right > 0 && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                if (left < s.length() - 1) left = left + 1;
                if (right > 0) right = right - 1;
            }
        }
        return true;
    }
}
