class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // 0 = empty, 1 = guard, 2 = wall, 3 = guarded

        // Mark guards
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 1;
        }

        // Mark walls
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 2;
        }

        // Mark guarded cells from each guard
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}}; // up, down, left, right
        for (int[] guard : guards) {
            for (int[] dir : directions) {
                int x = guard[0] + dir[0];
                int y = guard[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 1 && grid[x][y] != 2) {
                    grid[x][y] = 3; // guarded
                    x += dir[0];
                    y += dir[1];
                }
            }
        }

        // Count unguarded empty cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }

        return count; 
    }
}