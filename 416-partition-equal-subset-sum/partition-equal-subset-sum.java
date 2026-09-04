class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
       for(int num:nums){
         sum += num;
       } 
       if(sum%2 != 0) return false;
       int target = sum/2;
       int[][] dp = new int[nums.length][target+1];
       
       for(int i=0;i<nums.length;i++){
        dp[i][0] = 1;
       }
       for(int t=0;t<=target;t++){
         if(t == nums[0]){
            dp[0][t] = 1;
         }else{
            dp[0][t] = 2;
         }
       }

       for(int i=1;i<nums.length;i++){
        for(int t=1;t<=target;t++){
            int pick = 2;
            if(t>=nums[i]){
                pick = dp[i-1][t-nums[i]];
                dp[i][t] = pick;
            }
            int nopick = dp[i-1][t];
            dp[i][t] = (pick==1||nopick==1)?1:2;
        }
       }
       return dp[nums.length-1][target]==1?true:false;
    }
}