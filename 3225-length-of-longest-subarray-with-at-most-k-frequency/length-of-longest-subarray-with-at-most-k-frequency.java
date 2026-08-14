class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        int max_len = 0;
        while(i<n && j<n){
           if(map.getOrDefault(nums[j],0)<k){
             map.put(nums[j],map.getOrDefault(nums[j],0)+1);
             j++;
           }else{
             while(map.get(nums[j])>=k){
                map.put(nums[i],map.get(nums[i])-1);
                i++;
             }
           }
           max_len = Math.max(max_len,j-i);
        }
       return max_len;
    }
}