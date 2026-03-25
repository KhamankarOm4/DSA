class Solution {
    public int singleNumber(int[] nums) {

        HashMap<Integer,Integer> counts = new HashMap<>();

        for(int num:nums){
            int count = counts.getOrDefault(num,0);
            counts.put(num,count+1);
        }

        for(int key:counts.keySet()){
            if(counts.get(key)==1) return key;
        }
        
        return -1;
    }
}