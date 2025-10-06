class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
   
        pq.offer(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], r = cur[1], c = cur[2];
            if (r == n - 1 && c == n - 1) return cost;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n || vis[nr][nc]) continue;
                vis[nr][nc] = true;
                int ncost = Math.max(cost, grid[nr][nc]);
                pq.offer(new int[]{ncost, nr, nc});
            }
        }
        return -1;
    }
}