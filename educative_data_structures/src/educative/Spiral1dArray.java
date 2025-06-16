package educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Spiral1dArray {
    public static List<Integer> sprial(List<Integer> numbers, int k) {
        List<Integer> results = new ArrayList<>(numbers);
        int size = numbers.size();
        int refIndex = -1;
        for (int i = 0; i < size; i++) {
            if (numbers.get(i) == k) {
                refIndex = i;
                break;
            }
        }
        if (refIndex == -1) {
            return numbers;
        }

        int left = refIndex - 1;
        int right = refIndex + 1;
        int count = 1;
        results.set(refIndex, results.get(refIndex) + count++);
        while (left >= 0 || right < size) {
            if (right < size) {
                results.set(right, results.get(right) + count++);
                right++;
            }
            if (left >= 0) {
                results.set(left, results.get(left) + count++);
                left--;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(sprial(input, 4));
        List<Object> input1 = List.of(1, 2, "a", "b");
        filterList(input1);
    }

    public static List<Object> filterList(final List<Object> list) {

        list.stream().filter(val ->
        {
            boolean b = val.getClass().isInstance(Integer.class);
            return false;
        });
        return list;
    }
}
