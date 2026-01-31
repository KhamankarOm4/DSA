class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int sum = target - nums[i];
                if(hp.containsKey(sum)){
                    return new int[]{i,hp.get(sum)};
                }else{
                    hp.put(nums[i],i);
                }
        }
        
        return new int[0];
    }
}