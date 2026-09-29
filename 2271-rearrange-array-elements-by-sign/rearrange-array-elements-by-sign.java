class Solution {
    public int[] rearrangeArray(int[] nums) {
      Queue<Integer> Q1 = new ArrayDeque<>();
      Queue<Integer> Q2 = new ArrayDeque<>();

       for(int num:nums){
        if(num<0){
            Q2.offer(num);
        }else{
            Q1.offer(num);
        }
       }

       for(int i=0;i<nums.length;i++){
         if(i%2==0){
            nums[i] = Q1.poll();
         }else{
            nums[i] = Q2.poll();
         }
       }
       return nums; 
    }
}