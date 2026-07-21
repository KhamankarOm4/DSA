class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<buy){
                buy = prices[i];
                sell = 0;
            }else if(prices[i]>buy){
                sell = prices[i];
            }else{
                continue;
            }
            result = Math.max(result,sell-buy);
        }
        return result;
    }
}