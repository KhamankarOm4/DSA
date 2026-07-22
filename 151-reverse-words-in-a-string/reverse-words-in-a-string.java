class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        int n = words.length;
         for(int x=0;x<n;x++){
            System.out.println(words[x]);
         }
        int i=0;
        int j=n-1;
        while(i<j){
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for(int x=0;x<n;x++){
            if(words[x].equals("")){
                continue;
            }else{
            sb.append(words[x]);
            if(x != (n-1)){
                sb.append(" ");
            }
            }
        }
        return sb.toString();
    }
}