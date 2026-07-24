class Solution {
    public int findDuplicate(int[] nums) {
       // Phase 1: Detect that a cycle exists
        int tortoise = nums[0];
        int hare = nums[0];
        
        // Move tortoise by 1 step and hare by 2 steps until they meet
        do {
            tortoise = nums[tortoise];       // 1 step
            hare = nums[nums[hare]];     // 2 steps
        } while (tortoise != hare);
        
        // Phase 2: Find the entrance to the cycle (the duplicate element)
        tortoise = nums[0]; // Reset tortoise to the beginning
        
        // Move both pointers at the same speed (1 step) until they meet
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        
        return tortoise; // or return hare; both point to the duplicate
    }
}