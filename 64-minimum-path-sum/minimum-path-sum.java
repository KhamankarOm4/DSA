class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];  
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1 && j==1){
                    dp[i][j] = grid[i-1][j-1];
                }else if(i==1){
                    dp[i][j] = grid[i-1][j-1]+ dp[i][j-1];
                }else if(j==1){
                    dp[i][j] = grid[i-1][j-1]+ dp[i-1][j];
                }else{
                dp[i][j] = grid[i-1][j-1]+  Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}