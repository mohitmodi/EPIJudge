package exponent;

import java.util.HashMap;
import java.util.Map;

public class GoodSubArrayMultipleK {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(isGoodSubArray(k, arr));
    }

    private static boolean isGoodSubArray(int k, int[] arr) {
        if (arr == null || arr.length < 2) {
            return false;
        }
        Map<Integer, Integer> modKIndexMap = new HashMap<>();
        modKIndexMap.put(0, -1);
        int sumSoFarModK = 0;
        for (int i = 0; i < arr.length; i++) {
            sumSoFarModK = (arr[i] + sumSoFarModK % k) % k;
            if (modKIndexMap.containsKey(sumSoFarModK % k)) {
                int prevIndex = modKIndexMap.get(sumSoFarModK % k);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                modKIndexMap.put(sumSoFarModK % k, i);
            }

        }
        return false;
    }
}
