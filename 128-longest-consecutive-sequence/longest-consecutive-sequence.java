class Solution {
    public int longestConsecutive(int[] nums) {
       Arrays.sort(nums);
     
     int n =nums.length;
     if(n==0 || n==1) return n;
    int current = 1;
    int longest = 1;

    for(int i = 1; i < nums.length; i++){

        if(nums[i] == nums[i-1]){
            continue;   
        }

        if(nums[i] == nums[i-1] + 1){
            current++;
            longest = Math.max(longest, current);
        }else{
            current = 1;
        }
    }

    return longest;
    }
}