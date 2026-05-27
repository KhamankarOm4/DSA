class Solution {
    public int numberOfSpecialChars(String word) {
       int[] arr1 = new int[26];
       int[] arr2 = new int[26];

       Arrays.fill(arr1,-1);
       Arrays.fill(arr2,-1);

       HashSet<Integer> invalid = new HashSet<>();
       
       for(int i=0;i<word.length();i++){
        char c = word.charAt(i);
         if(c>='a' && c<='z'){
            int j = c-'a';
            arr1[j] = i;

            if(arr2[j] != -1){
                invalid.add(j);
            }
         }else{
            int j= c-'A';
            arr2[j] = i;

         }
       }
         int count = 0;
         for(int i=0;i<26;i++){
            if(arr1[i]!=-1 && arr2[i]!=-1 && !invalid.contains(i)){
                count++;
            }
         }
         return count;
    }
}