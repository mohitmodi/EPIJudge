package educative;

public class MinimumWindowSubsequence {
    public static String minimumWindowSubsequence(String s1, String s2) {

        int i = 0;
        int j = 0;
        int startIndex = 0;
        int endIndex = 0;
        String subString = "";

        while (i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                if (j == 0) {
                    startIndex = i;
                }
                j++;
                if (j == s2.length()) {
                    endIndex = i;
                    j = 0;

                    String currSmallSubSequence = s1.substring(startIndex, endIndex+1);
                    if (subString.isEmpty() || subString.length() > currSmallSubSequence.length()) {
                        subString = currSmallSubSequence;
                    }
                    i=startIndex;
                }
                i++;
            } else {
                i++;
            }

        }
        return subString;
    }

    public static void main(String[] args) {
        System.out.println(minimumWindowSubsequence("abcdbebe", "bbe"));
    }

}
