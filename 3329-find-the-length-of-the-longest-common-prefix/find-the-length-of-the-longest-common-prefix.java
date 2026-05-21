class Solution {
    int maxlen = 0;
    public int callen(int d){
            int count = 0;
            while(d>0){
                count++;
                d/=10;
            }
            return count;
        }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();

        for(int num:arr1){
           while(num>0){
            prefixes.add(num);
            num/=10;
           } 
        }

        for(int num:arr2){
             int len = callen(num);
            while(num>0){
            if(prefixes.contains(num)){
              maxlen = Math.max(maxlen,len);
            }
            num/=10;
            len--;
            }
        }

        return maxlen;
        
    }
}