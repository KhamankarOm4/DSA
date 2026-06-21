class Solution {
    public int maxIceCream(int[] costs, int coins) {
      int maxCost = 0;
      int ans = 0;
      for(int cost:costs){
        maxCost = Math.max(maxCost,cost);
      }

      int[] freq = new int[maxCost+1];

      for(int cost:costs){
        freq[cost]++;
      }

      for(int price = 1;price<=maxCost;price++){
        int canBuy = Math.min(freq[price],coins/price);
        ans += canBuy;
        coins -= canBuy*price;
        if(price>coins){
            break;
        }
      }
      return ans;
    }
}