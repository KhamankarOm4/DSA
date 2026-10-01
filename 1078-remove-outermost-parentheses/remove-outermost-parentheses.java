class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int ct1 = 0;
        int ct2 = 0;
        for(char ch: s.toCharArray()){
          if(ct1 == 0){
            ct1++;
          }else if(ch =='('){
            ct1++;
            if(ct1 != ct2){
                sb.append(ch);
            }else{
                ct1 = 0;
                ct2 = 0;
            }
          }else{
            ct2++;
            if(ct1 != ct2){
                sb.append(ch);
            }else{
                ct1 = 0;
                ct2 = 0;
            }
          }
        }
        return sb.toString();
    }
}