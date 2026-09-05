class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int maxnum = 0;
        int cookieindex = s.length-1;
        int childindex = g.length-1;
        while(cookieindex>= 0 && childindex>= 0){
            if(s[cookieindex]>=g[childindex]){
                maxnum++;
                cookieindex--;
                childindex--;
            }else{
                childindex--;
            }
        }
        return maxnum;
    }
}