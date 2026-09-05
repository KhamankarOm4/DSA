class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];;
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }

        for(int a=0;a<=amount;a++){
            if(a%coins[0]==0){
                dp[0][a] = 1;
            }else{
                dp[0][a] =  0;
            }
        }
        for(int i=1;i<n;i++){
            for(int a=1;a<=amount;a++){
                int pick = 0;
                if(a>=coins[i]){
                    pick = dp[i][a-coins[i]];
                }
                int nopick = dp[i-1][a];
                dp[i][a] = pick + nopick;
            }
        }
        return dp[n-1][amount];
    }
}