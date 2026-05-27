class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
         k = k%n;
         Queue<Integer> queue = new LinkedList<>();

         for(int i=n-k;i<n;i++){
            queue.offer(nums[i]);
         }
         for(int i=0;i<n-k;i++){
            queue.offer(nums[i]);
         }
         
         int i =0;
         while(!queue.isEmpty()){
           nums[i] = queue.poll();
           i++;
         }
        
    }
}