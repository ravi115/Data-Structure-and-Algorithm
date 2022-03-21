package AdvancedProblem.recursive;

import java.util.HashMap;
import java.util.Map;

public class GridTraversal {


    static int gridTraverse(int[][] grid, int start, int end, int i, int j, Map<String, Integer> memoization) {
        if (memoization.containsKey(i + ":" + j)) return memoization.get(i + ":" + j);
        if (i > start || j > end) return 0;
        else if (i == start && j == end) return 1;
        int res = gridTraverse(grid, start, end, i + 1, j, memoization) + gridTraverse(grid, start, end, i, j + 1, memoization);
        memoization.put(i + ":" +j, res);
        return memoization.get(start + ":" + end);

    }

    public static void main(String[] args) {
        Map<String, Integer> memoization = new HashMap<>();
        int[][] grid = new int[2][3];
        System.out.println("Total number of ways to reach to the grid ::" + gridTraverse(grid, 1, 2, 0, 0, memoization) );

        memoization.clear();
        int[][] grid2 = new int[18][18];
        System.out.println("Total number of ways to reach to the grid ::" + gridTraverse(grid2, 18, 18, 0, 0, memoization) );
    }

}
