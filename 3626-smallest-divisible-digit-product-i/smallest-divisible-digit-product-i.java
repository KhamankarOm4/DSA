class Solution {
    public int smallestNumber(int n, int t) {
      boolean flag = false;
      int num = n;
      while(!flag){
        int product = 1;
        int x = num;
        while(x>0){
            int temp = x%10;
            product = product * temp;
            x = x/10;
        }
        if(product%t == 0){
            flag = true;
        }
        num++;
      }
      return num-1;  
    }
}