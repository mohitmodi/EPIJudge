package educative;

import java.util.*;
import java.util.LinkedList;

public class FloodFill {
    public static int[][] floodFill(int[][] ff, int sr, int sc, int target) {
        Queue<Coordinate> queue = new LinkedList<>();
        Set<Coordinate> set = new HashSet<>();
        Coordinate orig = new Coordinate(sr, sc, ff[sr][sc]);
        queue.add(orig);
        set.add(orig);
        ff[sr][sc] = target;
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            int row = curr.row;
            int col = curr.col;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (isValid(newRow, newCol, ff)) {
                    Coordinate newCorr = new Coordinate(newRow, newCol, ff[newRow][newCol]);
                    if (orig.val == newCorr.val && !set.contains(newCorr)) {
                        ff[newRow][newCol] = target;
                        queue.add(newCorr);
                        set.add(newCorr);
                    }
                }
            }
        }
        return ff;

    }

    private static boolean isValid(int newRow, int newCol, int[][] ff) {
        return newRow >= 0 && newCol >= 0
                && newRow < ff.length
                && newCol < ff[0].length;
    }
    public static void main(String[] args){
        int[][][] grids = {
                {{1, 1, 0, 1, 0},
                        {0, 0, 0, 0, 1},
                        {0, 0, 0, 1, 1},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0}},

                {{1, 1, 0, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 1},
                        {1, 1, 1, 1}},

                {{9, 9, 6, 9},
                        {6, 9, 9, 6},
                        {6, 9, 9, 9},
                        {9, 9, 9, 9}},

                {{1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {0, 1, 1, 0},
                        {1, 0, 1, 1}},

                {{1, 2, 0, 0},
                        {3, 1, 3, 6},
                        {7, 2, 1, 5},
                        {1, 9, 2, 1}}
        };

        int[] sr = {4, 2, 2, 2, 1};
        int[] sc = {3, 3, 1, 3, 1};
        int[] target = {3, 2, 1, 0, 4};

        for (int i = 0; i < grids.length; i++) {
            System.out.println((i + 1) + ".\t Grid before flood fill: " + Arrays.deepToString(grids[i]));
            System.out.println("\t Starting row and column are: (" + sr[i] + ", " + sc[i] + ")");
            System.out.println("\t Target value: " + target[i]);

            int[][] result = floodFill(grids[i], sr[i], sc[i], target[i]);
            System.out.println("\t After perform flood fill: " + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}

class Coordinate {
    int row;
    int col;
    int val;

    public Coordinate(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Coordinate that = (Coordinate) o;
        if (this.row != that.row || this.col != that.col) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.row, this.col);

    }
//Coordinate original=new Coordinate(sr,sc,grid[sr][sc]);
//    Queue<Coordinate> queue=new LinkedList<>();
//    Set<Coordinate> visited =new HashSet<>();
//    queue.add(original);
//    visited.add(original);
//    grid[sr][sc]=target;
//
//
//    while(!(queue.isEmpty())){
//         Coordinate curr=queue.poll();
//
//        int [][] direction={{0,1},{1,0},{-1,0},{0,-1}};
//
//    for(int [] dir:direction){
//    int newRow=curr.row+dir[0];
//    int newCol=curr.col+dir[1];
//
//    if(newRow >=0 && newCol >= 0
//     && newRow < grid.length && newCol < grid[0].length){
//
//         Coordinate newCoodinate = new Coordinate(newRow,newCol,grid[newRow][newCol]);
//
//     if(newCoodinate.val==original.val
//     && !visited.contains(newCoodinate)){
//         queue.add(newCoodinate);
//         visited.add(newCoodinate);
//         grid[newRow][newCol]=target;
//     }
//}
//    }
//
//
//
//
//
//    }
//
//            return grid;
//
//    }
//
//   static class Coordinate{
//    int row;
//    int col;
//    int val;
//    Coordinate(int row,int col,int val){
//      this.row=row;
//      this.col=col;
//      this.val=val;
//    }
//
//   @Override
//    public boolean equals(Object o) {
//      if (this == o) {
//        return true;
//      }
//
//      if (o == null || getClass() != o.getClass()) {
//        return false;
//      }
//
//      Coordinate that = (Coordinate) o;
//      if (this.row != that.row || this.col != that.col) {
//        return false;
//      }
//
//      return true;
//    }
//
//    @Override
//    public int hashCode() {
//      return Objects.hash(this.row, this.col);
//    }
//  }
}
