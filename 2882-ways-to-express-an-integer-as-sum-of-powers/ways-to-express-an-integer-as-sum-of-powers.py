MOD = 10**9 + 7
class Solution(object):
    def numberOfWays(self, n, x):
        """
        :type n: int
        :type x: int
        :rtype: int
        """
        val = []
        i = 1
        while True:
            v = i**x
            if v > n:
                break
            val.append(v)
            i += 1

        dp = [0] * (n + 1)
        dp[0] = 1

        for v in val:
            for s in range(n, v - 1, -1):
                dp[s] = (dp[s] + dp[s - v]) % MOD

        return dp[n]