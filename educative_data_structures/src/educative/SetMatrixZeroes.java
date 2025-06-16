package educative;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static int[][] setZeroes(int[][] board) {
        int fc = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    if (j == 0)
                        fc = 0;
                    else {
                        board[0][j] = 0;
                    }
                    board[i][0] = 0;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    if (board[i][0] == 0 || board[0][j] == 0) {
                        board[i][j] = 0;
                    }
                }

            }
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        if (board[0][0] == 0) {
            for (int i = 0; i < board[0].length; i++) {
                board[0][i] = 0;
            }
        }

        if (fc == 0) {
            for (int i = 0; i < board.length; i++) {
                board[i][0] = 0;
            }
        }
        return board;
    }

    public static void main(String[] args) {
        int[][][] mat = {
                {{1, 1, 0}, {1, 0, 1}, {1, 1, 1}},
                {       {1, 1, 1, 1, 1},
                        {0, 0, 1, 1, 1},
                        {1, 1, 1, 1, 0},
                        {1, 1, 1, 1, 1}},
                {{3, 5, 2, 0}, {1, 0, 4, 6}, {7, 3, 2, 4}},
                {{1, 2, 3, 4}, {4, 5, 6, 7}, {8, 9, 4, 6}},
                {{2, 6, 5, 4, 9, 1}, {7, 2, 0, 0, 5, 4}, {1, 1, 1, 1, 0, 1}, {9, 8, 2, 0, 1, 3}, {7, 8, 6, 5, 4, 3}, {9, 8, 1, 2, 5, 6}}
        };

        for (int i = 0; i < mat.length; i++) {
            System.out.println((i + 1) + ". \tOriginal Matrix:");

            int[][] result = setZeroes(mat[i]);
            System.out.println("\n\tMatrix with Zeroes:");
            {
                // Loop through all rows
                for (int j = 0; j < mat[i].length; j++) {
                    // Loop through all elements of current row
                    for (int k = 0; k < mat[i][j].length; k++)
                        System.out.print(mat[i][j][k] + " ");
                    System.out.println();
                }
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
