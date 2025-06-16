package educative;

public class StringCompression {
    public static void main(String[] args) {
        String str = "aaabbccddeeff";
        String compressed = compressString(str);
        System.out.println(compressed);
    }

    public static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(count).append(str.charAt(i - 1));
                count = 1;
            }
        }
        
        // Append the last set of characters
        compressed.append(count).append(str.charAt(str.length() - 1));
        
        return compressed.toString();
    }
}