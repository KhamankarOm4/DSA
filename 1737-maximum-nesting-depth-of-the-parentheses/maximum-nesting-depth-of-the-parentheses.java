class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int leftp = 0;
        int rightp = 0;
        for(char ch:s.toCharArray()){
           if(ch == '('){
             leftp++;
           }else if(ch ==')'){
            rightp++;
           }
            depth = Math.max(depth,leftp-rightp);
        }
        return depth;
    }
}