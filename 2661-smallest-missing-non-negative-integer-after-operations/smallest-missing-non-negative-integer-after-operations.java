class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        long[] freq = new long[value];
        for (int x : nums) {
            int r = ((x % value) + value) % value;
            freq[r]++;
        }
        int m = 0;
        while (true) {
            int r = m % value;
            if (freq[r] > 0) {
                freq[r]--;
                m++;
            } else {
                return m;
            }
        }
    }
}