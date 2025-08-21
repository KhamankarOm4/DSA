class Solution(object):
    def numSubmat(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: int
        """
        rows , cols = len(mat) , len(mat[0])
        heights = [0] * cols
        ans = 0

        for r in range(rows):
            for c in range(cols):
                heights[c] = 0 if mat[r][c] == 0 else heights[c] + 1
            stack = []
            sum_rect = [0] * cols
            for c in range(cols):
                while stack and heights[stack[-1]] >= heights[c]:
                    stack.pop()
                if stack:
                    prev = stack[-1]
                    sum_rect[c] = sum_rect[prev] + heights[c] * (c - prev)
                else:
                    sum_rect[c] = heights[c] * (c + 1)
                stack.append(c)
                ans += sum_rect[c]
        return ans