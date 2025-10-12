class Solution {
    static final long MOD = 1_000_000_007L;

    static long modPow(long a, long e) {
        long r = 1 % MOD;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return r;
    }

    static long inv(long x) {
        return modPow(x, MOD - 2);
    }

    public int findSumOfArrayProductOfMagicalSequences(int[] nums, int m, int k) {
        int n = nums.length;
        int extraBits = m > 0 ? 32 - Integer.numberOfLeadingZeros(m) : 0;
        int B = Math.max(n, 1) + extraBits + 2;

        long[] fact = new long[m + 1];
        long[] invFact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) fact[i] = (fact[i - 1] * i) % MOD;
        invFact[m] = inv(fact[m]);
        for (int i = m - 1; i >= 0; i--) invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;

        long[][] fj = new long[n][m + 1];
        for (int j = 0; j < n; j++) {
            long base = (nums[j] % MOD + MOD) % MOD;
            long pow = 1;
            for (int c = 0; c <= m; c++) {
                fj[j][c] = (pow * invFact[c]) % MOD;
                pow = (pow * base) % MOD;
            }
        }

        long[][][] cur = new long[m + 1][m + 1][k + 1];
        cur[0][0][0] = 1;

        for (int bit = 0; bit < B; bit++) {
            long[][][] next = new long[m + 1][m + 1][k + 1];
            boolean valid = bit < n;

            for (int carry = 0; carry <= m; carry++) {
                for (int picked = 0; picked <= m; picked++) {
                    for (int ones = 0; ones <= k; ones++) {
                        long val = cur[carry][picked][ones];
                        if (val == 0) continue;
                        int maxC = m - picked;

                        if (!valid) {
                            int s = carry;
                            int newOnes = ones + (s & 1);
                            if (newOnes > k) continue;
                            next[s >> 1][picked][newOnes] = (next[s >> 1][picked][newOnes] + val) % MOD;
                        } else {
                            for (int c = 0; c <= maxC; c++) {
                                int s = carry + c;
                                int newOnes = ones + (s & 1);
                                if (newOnes > k) break;
                                long add = (val * fj[bit][c]) % MOD;
                                next[s >> 1][picked + c][newOnes] = (next[s >> 1][picked + c][newOnes] + add) % MOD;
                            }
                        }
                    }
                }
            }
            cur = next;
        }

        long res = cur[0][m][k];
        return (int) ((res * fact[m]) % MOD);
    }


    public int magicalSum(int m, int k, int[] nums) {
         return findSumOfArrayProductOfMagicalSequences(nums, m, k);

    }
}