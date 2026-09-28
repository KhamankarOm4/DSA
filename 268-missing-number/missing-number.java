class Solution {
    public int missingNumber(int[] nums) {
       int n = nums.length;
        boolean[] seen = new boolean[n + 1];
        for (int c : nums) {
            seen[c] = true;
        }
        for (int i = 0; i < n; i++) {
            if (!seen[i]) return i;
        }
        return n;  
    }
}