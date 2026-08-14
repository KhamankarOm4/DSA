class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int total = 0;
        int count = 0;
        for(int num:nums){
            total += num;

            int mod = total%k;
            if(mod<0){
                mod += k;
            }
            if(map.containsKey(mod)){
                count += map.get(mod);
                map.put(mod,map.get(mod)+1);
            }else{
                map.put(mod,1);
            }
        }
        return count;
    }
}