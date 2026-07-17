class Solution {
    public int[] countBits(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        for(int i =0;i<=n;i++){
          recur(dp,i);  
        }
        return dp;
    }

    public int recur(int[] dp , int n){
       if(n == 0){
        dp[0] = 0;
        return dp[0];
       }
       if(dp[n]!=-1){
        return dp[n];
       }
       dp[n] = recur(dp,n>>1) + (n&1);
       return dp[n];
    }
}