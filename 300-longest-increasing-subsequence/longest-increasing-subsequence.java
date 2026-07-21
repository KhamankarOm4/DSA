class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis,1);
        int maxlen = 0;
        if(n == 1) return 1;
        for(int i=1;i<n;i++){
            for(int p=0;p<i;p++){
                if(nums[p]<nums[i]){
                    lis[i]=Math.max(lis[i],lis[p]+1);
                }
            }
            if(lis[i]>maxlen){
                maxlen = lis[i];
            }
        }
        return maxlen;
    }
}