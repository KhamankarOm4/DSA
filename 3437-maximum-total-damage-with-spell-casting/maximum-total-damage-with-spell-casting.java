class Solution {
    public long maximumTotalDamage(int[] power) {
          Map<Integer, Long> frq = new HashMap<>();
        for (int p : power) {
            frq.put(p,    frq.getOrDefault(p, 0L) + 1);
        }

      
        List<Integer> keys = new ArrayList<>(frq.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];
        
        dp[0] = keys.get(0) * frq.get(keys.get(0));

        for (int i = 1; i < n; i++) {
            long currDamage = keys.get(i) * frq.get(keys.get(i));
            int j = i - 1;

            while (j >= 0 && keys.get(i) - keys.get(j) <= 2) j--;

            long inc= currDamage + (j >= 0 ? dp[j] : 0);
            long exc = dp[i - 1];

            dp[i] = Math.max(inc, exc);
        }

        return dp[n - 1];
    }
}