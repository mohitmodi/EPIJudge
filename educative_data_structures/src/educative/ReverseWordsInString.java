package educative;

//reverse this string
public class ReverseWordsInString {
    public static String reverseWords(String sentence) {
        sentence = sentence.replaceAll("\\s+", " ").trim();
        char[] charArray = sentence.toCharArray();
        rev(charArray, charArray.length - 1, 0);


        for (int start = 0, end = 0; end <= charArray.length-1; end++) {
            if (charArray[end] == ' ' || end == charArray.length-1) {
                int endIdx = (end == charArray.length-1 ) ? end : end - 1;
                rev(charArray, endIdx, start);
                start = end+1;
            }
        }
        return new String(charArray);
    }


    private static void rev(char[] charArray, int end, int start) {
        for (int i = start, j = end; i <= j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Hello     World"));
    }
}
