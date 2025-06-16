package grind88;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        /*int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));*/

        int[][] image = new int[][]{{0, 0, 0}, {0, 0, 0}};
        int sr = 0;
        int sc = 0;
        int color = 0;
        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Coordinate> queue = new LinkedList<>();
        HashSet<Coordinate> visited = new HashSet<>();
        int origColor = image[sr][sc];
        if (origColor == color) {
            return image;
        }
        int matrixLenght = image.length;
        int matrixcolumn = image[0].length;


        queue.add(new Coordinate(sr, sc, origColor));
        visited.add(new Coordinate(sr, sc, origColor));

        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            int[][] directions = new int[][]{{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
            for (int[] dir : directions) {
                int nr = curr.row + dir[0];
                int nc = curr.col + dir[1];
                if (validate(nr, nc, matrixLenght, matrixcolumn) && origColor == image[nr][nc]) {
                    Coordinate newCoordinate = new Coordinate(nr, nc, image[nr][nc]);
                    if (!visited.contains(newCoordinate)) {
                        queue.add(newCoordinate);
                        visited.add(newCoordinate);
                    }
                }
            }
            image[curr.row][curr.col] = color;
        }

        return image;
    }

    private static boolean validate(int nr, int nc, int matrixLenght, int matrixcolumn) {
        return nr >= 0 && nr < matrixLenght && nc >= 0 && nc < matrixcolumn;
    }
}

class Coordinate {
    int row;
    int col;
    int color;

    Coordinate(int row, int col, int color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }
}
