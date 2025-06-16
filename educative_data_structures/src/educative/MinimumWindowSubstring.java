package educative;

//A B A A C B B A

import java.util.HashMap;
import java.util.Map;

//A B C
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        String subString = "";
        Map<Character, Integer> targetFrequency = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetFrequency.put(t.charAt(i), targetFrequency.getOrDefault(t.charAt(i), 0) + 1);
        }
        int start = 0;
        int end = 0;
        int current = 0;
        int required = t.length();
        Map<Character, Integer> windowFrequency = new HashMap<>();
        while (end < s.length()) {
            char currChar = s.charAt(end);
            windowFrequency.put(currChar, windowFrequency.getOrDefault(s.charAt(end), 0) + 1);
            if (targetFrequency.containsKey(currChar)
                    && windowFrequency.containsKey(currChar)
                    && windowFrequency.get(currChar).equals(targetFrequency.get(currChar))) {
                current+=targetFrequency.get(currChar);
            }
            while (current == required) {
                if (!subString.isEmpty()) {
                    subString = subString.length() < end - start + 1 ? subString : s.substring(start, end + 1);
                } else {
                    subString = s.substring(start, end + 1);
                }

                windowFrequency.put(s.charAt(start), windowFrequency.get(s.charAt(start)) - 1);
                if (targetFrequency.containsKey(s.charAt(start)) && windowFrequency.containsKey(s.charAt(start))
                        && windowFrequency.get(s.charAt(start)) < (targetFrequency.get(s.charAt(start)))) {
                    current--;
                }
                start++;
            }
            end++;

        }
        return subString;
    }

    public static void main(String[] args) {
        String s = "wzluecvbdwazkkejrbpirqperabqaerahuwfczyyllfheyddiuhbttbjjtivsybmywuynowihocztmvltykshcbgasyqvyftbknrrragxnhoqmbsgmxfdfsiaxbrpcnaapahueumuxnykgoszvkerrkuxixjkgiqrpzdzsgtwxglgjnekkbrualeasrwxccaagyvjhurahbszieqtqcmqbtlpudysqshxkaohybhuhmcsthmkapliwkdjkeuwarbrgeykefirzvxocwdmegbtnxrivogmizvisgbegoqyvwkghnrmoderqntatsoctyzosutvbhwvwhmiubhayavdeggpeitdormdpaygvqgfywtrexcxocnrnrpcwuykbvtgrgdsjayhlryjggneeprqnjnffpeqmwfmujqlpsjgnerjbtlqbhbzaxlcgovczftcdxqwewrslzblundmiwojtzstiooxlbhyzuoxlmjwycwwodwsbevifvuqlluazbjjabdrmfmipaewhpwajsuvwzhqgtfagcmrppsbmzeorpkncvxlbjainamesqinwjvotulflkkpxbhvuordclpkfjwguqecolajniisxojrcgsiodjfgiuopoyvnnrxgkeckwqrngpfezlycxdfgvizxhgsuaykpncsbggapnufugobsfzezkbowjpjwxecnzefshtplcfphvdjknlozcmbxzasggmrfmipwzuktwjanagrlslkfmhffuyjftencafuerjkftrnqnavukezgddoguhmcuiwohpqqdgwrotuvuyqekniolhdllpdmjkfoxqkmawvdefnhhxrvtdeuvpxycbbgolphdfejbjwzsutolvoayadlayijipgnktlwmvglhundiiqawthyvkfcodxvakmdsfdpasdrbudkjfxlabzmsbdsenazfvafxdaydfrrmmyxifjocusbejtbsjbjilcrxorbgfenfvxgdl";
        String t = "wzluecvbdwazkkejrbpirqperabqaerahuwfczyyllfheyddiuhbttbjjtivsybmywuynowihocztmvltykshcbgasyqvyftbknrrragxnhoqmbsgmxfdfsiaxbrpcnaapahueumuxnykgoszvkerrkuxixjkgiqrpzdzsgtwxglgjnekkbrualeasrwxccaagyvjhurahbszieqtqcmqbtlpudysqshxkaohybhuhmcsthmkapliwkdjkeuwarbrgeykefirzvxocwdmegbtnxrivogmizvisgbegoqyvwkghnrmoderqntatsoctyzosutvbhwvwhmiubhayavdeggpeitdormdpaygvqgfywtrexcxocnrnrpcwuykbvtgrgdsjayhlryjggneeprqnjnffpeqmwfmujqlpsjgnerjbtlqbhbzaxlcgovczftcdxqwewrslzblundmiwojtzstiooxlbhyzuoxlmjwycwwodwsbevifvuqlluazbjjabdrmfmipaewhpwajsuvwzhqgtfagcmrppsbmzeorpkncvxlbjainamesqinwjvotulflkkpxbhvuordclpkfjwguqecolajniisxojrcgsiodjfgiuopoyvnnrxgkeckwqrngpfezlycxdfgvizxhgsuaykpncsbggapnufugobsfzezkbowjpjwxecnzefshtplcfphvdjknlozcmbxzasggmrfmipwzuktwjanagrlslkfmhffuyjftencafuerjkftrnqnavukezgddoguhmcuiwohpqqdgwrotuvuyqekniolhdllpdmjkfoxqkmawvdefnhhxrvtdeuvpxycbbgolphdfejbjwzsutolvoayadlayijipgnktlwmvglhundiiqawthyvkfcodxvakmdsfdpasdrbudkjfxlabzmsbdsenazfvafxdaydfrrmmyxifjocusbejtbsjbjilcrxorbgfenfvxgdl";

        System.out.println(minWindow(s, t));
    }
}
