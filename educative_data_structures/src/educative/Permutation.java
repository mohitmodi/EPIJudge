package educative;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static ArrayList<String> permuteWord(String word) {
        ArrayList<String> result = new ArrayList<>();
        permuteWord(word, result, new StringBuilder());
        return result;
    }

    private static void permuteWord(String word, ArrayList<String> result, StringBuilder currResult) {
        if (currResult.length() == word.length()) {
            result.add(currResult.toString());
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            if (currResult.toString().contains(String.valueOf(word.charAt(i)))) {
                continue;
            }
            currResult.append(word.charAt(i));
            permuteWord(word, result, currResult);
            currResult.deleteCharAt(currResult.length()-1);
        }
    }
}
