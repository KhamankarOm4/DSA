class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;  // Day 1: 1 person knows the secret

        for (int i = 1; i <= n; i++) {
            long spread = dp[i];
            if (spread == 0) continue;
            for (int j = i + delay; j < i + forget && j <= n; j++) {
                dp[j] = (dp[j] + spread) % mod;
            }
        }

        long ans = 0;
        // Count people who still remember at day n
        for (int i = n - forget + 1; i <= n; i++) {
            if (i > 0) ans = (ans + dp[i]) % mod;
        }
        return (int) ans;
    }
}