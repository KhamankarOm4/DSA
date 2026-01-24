class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count =0;
       for(int i=left;i<=right;i++){

        char s = words[i].charAt(0);
        char e = words[i].charAt(words[i].length()-1);

        if(s=='a'||s=='e'||s=='o'||s=='i'||s=='u'){
            if(e=='a'||e=='e'||e=='o'||e=='i'||e=='u'){
                       count++;
            }
        }
       } 
       return count;
    }
}