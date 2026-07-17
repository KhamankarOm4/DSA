class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            dp[i]=Math.min(cost[i-1] + dp[i-1],cost[i-2] + dp[i-2]);
        }
        return dp[n];
        

    }

    // public int recur(int n,int[] cost,int[] dp){
    //    if(n==0 || n ==1){
    //     dp[n] = 0;
    //     return 0;
    //    }
    //    if(dp[n]!=-1){
    //     return dp[n];
    //    }
    //    int oneStep = cost[n-1] + recur(n-1,cost,dp);
    //    int twoStep = cost[n-2] + recur(n-2,cost,dp);
    //    dp[n] = Math.min(oneStep,twoStep);
    //    return dp[n];
    // }
}