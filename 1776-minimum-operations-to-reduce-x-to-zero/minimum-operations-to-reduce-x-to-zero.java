class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0;
        int totalsum = 0;
        for(int num:nums){
            totalsum += num;
        }
        if(totalsum == x) return nums.length;
        int target = totalsum - x ;
        int length = 0;
        int sum = 0;
        for(int right=0;right<nums.length;right++){
           sum += nums[right];
           while(left<=right && sum>target){
            sum -= nums[left];
            left++;
           }
           if(sum == target) length = Math.max(length,right-left+1);
        }
        return (length==0)?-1:nums.length-length;
    }
}