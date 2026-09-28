class Solution {
    public int search(int[] nums, int target) {
       int left =0;
       int right = nums.length-1; 

       while(left<=right){
        int md = left + (right-left)/2;

        if(nums[md] == target){
            return md;
        }

        if(nums[left] <= nums[md]){
            if (nums[left] <= target && target < nums[md]){
                right = md-1;
            }else{
                left = md+1;
            }
        }else{
            if (nums[right] >= target && target > nums[md]){
                left = md+1;
            }else{
                right = md-1;
            }
        }

       }
       return -1;
    }
}