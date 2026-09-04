class Solution {
    public int solution(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<=n;i++){
           int case1 = nums[i-1] + dp[i-2];
           int case2 = dp[i-1];
           dp[i] = Math.max(case1,case2);
        }
        return dp[n];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int[] nums1 = new int[n-1];
        int[] nums2 = new int[n-1];
        int a = 0;
        int b = 0;
        for(int i=0;i<n;i++){
            if(i != 0){
                nums1[a] = nums[i];
                a++; 
            }
            if(i != n-1){
                nums2[b] = nums[i];
                b++; 
            }
        }
        return Math.max(solution(nums1),solution(nums2));
    }
}