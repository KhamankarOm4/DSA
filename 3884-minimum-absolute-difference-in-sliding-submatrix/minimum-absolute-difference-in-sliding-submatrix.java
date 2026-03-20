class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n-k+1][m-k+1];

        for(int i=0;i<=n-k;i++){
            for(int j=0;j<=m-k;j++){

                ArrayList<Integer> res = new ArrayList<>();

                for(int x=i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        res.add(grid[x][y]);
                    }
                }

            TreeSet<Integer> set = new TreeSet<>(res);
            List<Integer> unique = new ArrayList<>(set);

            if(unique.size() < 2){
                result[i][j] = 0;
                continue;
            }

            int minDiff = Integer.MAX_VALUE;
            for(int t=1;t<unique.size();t++){
                minDiff = Math.min(minDiff, unique.get(t) - unique.get(t-1));
            }

                result[i][j] = minDiff;

            }
        }
        return result;
    }
}