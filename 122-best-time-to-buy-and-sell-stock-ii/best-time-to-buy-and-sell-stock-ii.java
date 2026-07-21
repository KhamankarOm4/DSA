class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,1,prices,dp);
    }

    public int solve(int i,int buy,int[] prices,int[][] dp){
        if(i == prices.length){
            return 0;
        }

        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        if(buy == 1){
            int buyit = -prices[i] + solve(i+1,0,prices,dp);
            int skip = solve(i+1,1,prices,dp);
            dp[i][buy] = Math.max(buyit,skip);
            return dp[i][buy];
        }else{
            int sellit = prices[i] + solve(i+1,1,prices,dp);
            int hold = solve(i+1,0,prices,dp);
            dp[i][buy] = Math.max(sellit,hold);
            return dp[i][buy];
        }
    }
}