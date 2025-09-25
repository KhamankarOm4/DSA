class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        n = len(triangle)
        # Use 1D array with extra space to avoid boundary checks
        dp = [0] * (n + 1)
        
        # Process from bottom to top
        for row in range(n - 1, -1, -1):
            for col in range(row + 1):
                # Current minimum = current value + min of two paths below
                dp[col] = min(dp[col], dp[col + 1]) + triangle[row][col]
        
        return dp[0]