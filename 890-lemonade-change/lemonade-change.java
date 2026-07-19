class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                fives++;
            }else if(bills[i]==10){
                if(!(fives >= 1)){
                    return false;
                }
                fives--;
                tens++;
            }else{
               int flag1 = 0;
               int flag2 = 0; 
               if( (tens >= 1) && (fives >= 1) ){
                  flag1 = 1;
                  tens--;
                  fives--;
               }else if( fives >= 3){
                 flag2 = 1;
                 fives -= 3;
               }
             
              if(!(flag1 == 1 || flag2 == 1)){
                return false;
              }
            }
        }
        return true;
    }
}