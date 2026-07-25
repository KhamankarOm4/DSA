class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mostfreqletter = 0;
        int left = 0;
        int max = 0;
        for(int right = 0;right<s.length();right++){
            freq[s.charAt(right)-'A']++;
            mostfreqletter = Math.max(mostfreqletter,freq[s.charAt(right)-'A']);

            int lettertochange = (right-left+1)-mostfreqletter;
            if(lettertochange>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            max = Math.max(max,(right-left+1));
        }
        return max;
        }
}