class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer , Integer> map = new HashMap<>();

        int count = 0;

        int right = 0;

        int sum = 0;

        while(right < nums.length){
            sum += nums[right];

            if(sum == goal)
                count++;


            if(map.containsKey(sum - goal)){
                count += map.get(sum-goal) ;
            }
            
            map.put(sum , map.getOrDefault(sum , 0) + 1);

            right++;
        }

        return count;
    }
}