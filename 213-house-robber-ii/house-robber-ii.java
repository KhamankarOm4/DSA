class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] nums1 = new int[n-1];
        int[] nums2 = new int[n-1];
        
        int c1 = 0;
        int c2 = 0;
        for(int i=0;i<n;i++){
            if(i != 0){
             nums1[c1] = nums[i];
             c1++;
            }
            if(i != n-1){
             nums2[c2] = nums[i];
             c2++;
            }
        }
        if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0]=0;
        dp2[0]=0;
        dp1[1]=nums1[0];
        dp2[1]=nums2[0];
        for(int i=2;i<n;i++){
           int pick1 = nums1[i-1]+dp1[i-2];
           int nopick1 = dp1[i-1];
            dp1[i] = Math.max(pick1,nopick1);

           int pick2 = nums2[i-1]+dp2[i-2];
           int  nopick2 = dp2[i-1];
            dp2[i] = Math.max(pick2,nopick2);
        }
        return Math.max(dp1[n-1],dp2[n-1]);
    }
}