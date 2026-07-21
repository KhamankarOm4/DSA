class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int x = target - nums[i];

            if(map.containsKey(x)){
               int y = map.get(x);
               if( y!= i) return new int[]{i,y};
            }
        }
        return new int[]{-1,-1};
    }
}