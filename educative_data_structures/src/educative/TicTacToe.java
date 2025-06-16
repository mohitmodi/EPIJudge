package educative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicTacToe {
    List<Integer> rows;
    List<Integer> cols;
    int diag;
    int antidiag;

    TicTacToe(int n) {
        this.rows = new ArrayList<>(Collections.nCopies(n, 0));
        this.cols = new ArrayList<>(Collections.nCopies(n, 0));
        diag = 0;
        antidiag = 0;
    }

    public int move(int row, int col, int player) {
        int n = rows.size();
        int currPlayer = player == 1 ? 1 : -1;
        rows.set(row, rows.get(row) + currPlayer);
        cols.set(col, cols.get(col) + currPlayer);
        if (row == col) {
            diag += currPlayer;
        }
        if (col == n - row - 1) {
            antidiag += currPlayer;
        }
        if (Math.abs(rows.get(row)) == n ||
                Math.abs(cols.get(col)) == n
                || Math.abs(diag) == n
                || Math.abs(antidiag) == n) {
            return player;
        }
        return 0;
    }

}
