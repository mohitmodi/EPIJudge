package educative;

public class JumpGame1 {
    public static boolean jumpGame(int[] num) {
        int newTarget = num.length - 1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (i + num[i] - newTarget<0) {
                return false;
            } else {
                newTarget = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] num = new int[]{4,0,0,0,4};
        System.out.println(jumpGame(num));

    }
}
