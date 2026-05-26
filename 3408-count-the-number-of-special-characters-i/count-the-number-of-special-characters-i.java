class Solution {
    public int numberOfSpecialChars(String word) {
        int sum = 0;
        boolean[] presentS = new boolean[26];
        boolean[] presentC = new boolean[26];

        for(int i=0;i<word.length();i++){
           char c = word.charAt(i);
            if(Character.isLowerCase(c)){
                  presentS[c-'a'] = true;
            }else if(Character.isUpperCase(c)){
                 presentC[c-'A'] = true;
            }else{
                continue;
            }
        }

        for(int i=0;i<presentS.length;i++){
            if(presentS[i]==true && presentC[i]==true){
                sum++;
            }
        }
        return sum;
    }
}