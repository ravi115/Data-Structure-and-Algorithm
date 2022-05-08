package graph;

/**
 * LC: 200
 */
public class NumberOfIsland {

    private static class Solution {
        public int numIslands(char[][] grid) {

            int num = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        num += 1;
                        explore(grid, i, j, grid.length, grid[0].length);
                    }
                }
            }
            return num;
        }


        private void explore(char[][] grid, int i, int j, int r, int c) {

            if (i < 0 || i >= r || j < 0 || j >= c || grid[i][j] == '2' || grid[i][j] == '0') return;
            grid[i][j] = '2';
            explore(grid, i - 1, j, r, c);
            explore(grid, i + 1, j, r, c);
            explore(grid, i, j - 1, r, c);
            explore(grid, i, j + 1, r, c);
        }
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        Solution solution = new Solution();

        System.out.println("Total number of island :: " + solution.numIslands(grid));
    }
}
