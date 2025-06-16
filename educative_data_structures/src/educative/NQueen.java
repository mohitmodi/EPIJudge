package educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    public static int solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueen(n, 0, result, new ArrayList<Integer>());
        return result.size();
    }

    private static void solveNQueen(int n, int row, List<List<Integer>> noOfWays, ArrayList<Integer> colPlacement) {
        if (row == n) {
            noOfWays.add(colPlacement);
        }
        for (int col = 0; col < n; col++) {
            colPlacement.add(col);
            if (isValid(colPlacement)) {
                solveNQueen(n, row + 1, noOfWays, colPlacement);
            }
            colPlacement.remove(colPlacement.size() - 1);
        }
    }

    private static boolean isValid(ArrayList<Integer> colPlacement) {
        int rowWeAreValidatingOn = colPlacement.size() - 1;
        for (int i = 0; i < rowWeAreValidatingOn; i++) {
            int absColumnDistance = Math.abs(colPlacement.get(i) - colPlacement.get(rowWeAreValidatingOn));
            int rowDistance = rowWeAreValidatingOn - i;
            if (absColumnDistance == 0 || absColumnDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {

        List<Integer> n = Arrays.asList(4, 5, 6, 7);
        for (int i = 0; i < n.size(); i++) {
            int res = solveNQueens(n.get(i));
            System.out.println((i + 1) + ".  Total solutions count for " + n.get(i) + " queens on the chessboard (" + n.get(i) + "x" + n.get(i) + "): " + res);
            System.out.println("-------------------------------------------------------------------------------------\n");
        }
    }
}
