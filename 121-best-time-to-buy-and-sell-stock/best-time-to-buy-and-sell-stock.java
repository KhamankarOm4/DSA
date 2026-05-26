class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        int max = 0;
        for(int i=0;i<prices.length;i++){
              if(prices[i]<buy){
                buy = prices[i];
                sell = 0;
              }else if(prices[i]>sell){
                sell = prices[i];
              }else{
                continue;
              }
              max = Math.max(max,sell-buy);
        }
        return max;
    }
}