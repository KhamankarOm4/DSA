class Solution {
    public int singleNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            str[i]=Integer.toString(nums[i]);
        }

        HashMap<String,Integer> counts = new HashMap<>();

        for(String s:str){
            int count = counts.getOrDefault(s,0);
            counts.put(s,count+1);
        }

        for(String key:counts.keySet()){
            if(counts.get(key)==1) return Integer.parseInt(key);
        }
        
        return -1;
    }
}