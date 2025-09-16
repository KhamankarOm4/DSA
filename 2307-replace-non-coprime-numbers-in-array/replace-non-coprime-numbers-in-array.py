class Solution(object):
    @staticmethod
    def gcd(a, b):
        while b:
            a, b = b, a % b
        return a

    @staticmethod
    def lcm(a, b):
        return a * b // Solution.gcd(a, b)

    def replaceNonCoprimes(self, nums):
        stack = []
        for num in nums:
            while stack and Solution.gcd(stack[-1], num) > 1:
                num = Solution.lcm(stack.pop(), num)
            stack.append(num)
        return stack
