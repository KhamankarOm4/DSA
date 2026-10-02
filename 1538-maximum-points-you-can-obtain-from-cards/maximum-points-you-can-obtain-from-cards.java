class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int totalsum = 0;
        for(int x:cardPoints){
            totalsum += x;
        }
        for(int right =0;right<cardPoints.length;right++){
            sum += cardPoints[right];
            while((right-left+1)>n-k){
                sum -= cardPoints[left];
                left++;
            }
            if((right-left+1)==n-k){
                ans = Math.min(ans,sum);
            }
        }
        return totalsum-ans;
    }
}