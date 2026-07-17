class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        int prev2 = 0;
        int prev1 = nums[0];
        if(n==1){
            return nums[0];
        }
        for(int i=2;i<=n;i++){
         int pick = nums[i-1]+prev2;
         int nopick = 0 + prev1;
          dp[i] = Math.max(pick,nopick);
          prev2 = prev1;
          prev1 = dp[i];
        }
        return dp[n];
    }
}