class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int req = target - num;
    
            if(map.containsKey(req) && map.get(req)!=i){
                return new int[] {i,map.get(req)};
            }
        }
      return new int[] {-1,-1};
        
    }
}