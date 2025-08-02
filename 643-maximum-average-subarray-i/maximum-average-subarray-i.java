class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int current=0;
        int max=0;

        for(int i=0;i<k;i++){
            current+=nums[i];
        }
        max=current;
        for(int i=k;i<nums.length;i++){
            current=current+nums[i]-nums[i-k];
             if(current>max){
                 max=current;
        }
        }

        return (double)max/k;
    }
}