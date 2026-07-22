class Solution {
    public String longestCommonPrefix(String[] strs) {
       int n = strs.length;
       int prefix = Integer.MAX_VALUE;
       int idx = 0;
       int maxlen = strs[0].length();
       if(strs.length == 1) return strs[0];
       for(int i=1;i<n;i++){
         int j =0;
         while(j < strs[i-1].length()
      && j < strs[i].length()
      && strs[i-1].charAt(j) == strs[i].charAt(j)){
            j++;
         }
         prefix = Math.min(prefix,j);
         if(strs[i].length()>maxlen){
            maxlen = strs[i].length();
            idx = i;
         }
       }
       if(prefix==0) return "";
       return strs[idx].substring(0,prefix);
    }
}