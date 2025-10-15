class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n < 2) return 0;
        int pre = 0, cur = 1, ans = 0;
        for (int i = 1; i < n; ++i) {
            if (nums.get(i - 1) < nums.get(i)) {
                ++cur;
            } else {
                ans = Math.max(ans, cur / 2);
                ans = Math.max(ans, Math.min(pre, cur));
                pre = cur;
                cur = 1;
            }
        }
        ans = Math.max(ans, cur / 2);
        ans = Math.max(ans, Math.min(pre, cur));
        return ans;
    }
}