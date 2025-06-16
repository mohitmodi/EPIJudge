package educative;

import java.util.*;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bill) {
        int currentChange5 = 0;
        int currentChange10 = 0;
        for (int i = 0; i < bill.length; i++) {
            if (bill[i] == 5) {
                currentChange5++;
            } else if (bill[i] == 10) {
                if (currentChange5 <= 0) {
                    return false;
                }
                currentChange10++;
                currentChange5--;
            } else if (bill[i] == 20) {
                if (currentChange10 > 0 && currentChange5 > 0) {
                    currentChange10--;
                    currentChange5--;
                } else if (currentChange5 > 3) {
                    currentChange5--;
                    currentChange5--;
                    currentChange5--;
                } else return false;
            }


        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}