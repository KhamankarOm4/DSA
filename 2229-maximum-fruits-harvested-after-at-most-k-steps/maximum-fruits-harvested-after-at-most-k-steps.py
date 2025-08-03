class Solution(object):
    def maxTotalFruits(self,fruits, startPos, k):
        positions = [pos for pos, _ in fruits]
        prefix = [0]
        for _, amount in fruits:
            prefix.append(prefix[-1] + amount)

        def totalFruits(left, right):
            i = bisect_left(positions, left)
            j = bisect_right(positions, right)
            return prefix[j] - prefix[i]

        result = 0

        for left_steps in range(k + 1):
            left = startPos - left_steps
            right = startPos + (k - 2 * left_steps)
            if right >= left:
                result = max(result, totalFruits(left, right))

        for right_steps in range(k + 1):
            right = startPos + right_steps
            left = startPos - (k - 2 * right_steps)
            if left <= right:
                result = max(result, totalFruits(left, right))

        return result
        # """
        # :type fruits: List[List[int]]
        # :type startPos: int
        # :type k: int
        # :rtype: int
        # """
        # n=len(fruits)
        # left=0
        # total=0
        # max_s=0

        # for right in range(n):
        #     total+=fruits[right][1]

        #     while left<=right:
        #         leftpos=fruits[left][0]
        #         rightpos=fruits[right][0]

        #         steps=min(  abs(startPos - leftpos) + (rightpos - leftpos),
        #         abs(startPos - rightpos) + (rightpos - leftpos))

        #         if steps<=k:
        #            break
        #         else:
        #             total-=fruits[left][1]
        #             left+=1

        # return max(max_s,total)            




        