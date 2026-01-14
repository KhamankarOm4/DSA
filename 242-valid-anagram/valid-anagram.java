class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        if(s.length() != t.length()){
            return false;
        }

        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
         for(char c1:t.toCharArray()){
            arr[c1-'a']--;
        }
        
        for(int i=0;i<26;i++){
            if(arr[i]!=0){
                return false;
            }
        }

        return true;
    }
}