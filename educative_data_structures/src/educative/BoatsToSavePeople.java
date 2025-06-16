package educative;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static int rescueBoats(int[] people, int limit) {
        int maxBoats = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1 ;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
                maxBoats++;
            } else {
                j--;
                maxBoats++;
            }
        }
        return maxBoats;
    }

    public static void main(String[] args) {
        int pep[] = new int[]{1,1,1,1,2};
        int limit = 3;
        System.out.println(rescueBoats(pep,limit));
    }
}
