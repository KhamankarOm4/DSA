class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet seen = new HashSet();

        for(int x : nums){
            if(seen.contains(x)){
                return x;

            }
            seen.add(x);
        }

        return-1;
        
    }
}