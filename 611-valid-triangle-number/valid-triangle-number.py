class Solution(object):
    def triangleNumber(self, nums):
        nums.sort()  # Sort the array first
        n = len(nums)
        count = 0
        
        # Fix the largest side (iterate from right)
        for i in range(n - 1, 1, -1):
            left = 0
            right = i - 1
            
            # Use two pointers for smaller sides
            while left < right:
                if nums[left] + nums[right] > nums[i]:
                    # All pairs from left to right-1 form valid triangles
                    count += right - left
                    right -= 1
                else:
                    left += 1  # Need larger sum
        
        return count