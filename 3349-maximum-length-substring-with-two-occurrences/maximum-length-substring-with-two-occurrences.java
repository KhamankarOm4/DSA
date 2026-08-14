class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int max_len = 0;
        while(i<n && j<n){
           if(map.getOrDefault(s.charAt(j),0)<2){
             map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
             j++;
           }else{
             while(map.get(s.charAt(j))>=2){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
             }
           }
           max_len = Math.max(max_len,j-i);
        }
       return max_len;
    }
}