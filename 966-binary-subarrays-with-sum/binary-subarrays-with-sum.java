class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
      HashMap<Integer,Integer> map =new  HashMap<>();
      map.put(0,1);
      int total = 0;
      int count = 0;
      for(int num:nums){
        total += num;
        if(map.containsKey(total-goal)){
            count += map.get(total-goal);
        }
        map.put(total,map.getOrDefault(total,0)+1);
      }
      return count;
    }
}