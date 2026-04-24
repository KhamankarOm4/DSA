class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int l =0;
        int r = 0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i) == 'L'){
                l++;
            }else if(moves.charAt(i)=='R'){
                r++;
            }else{
                continue;
            }
        }
        
        if(r>=l){
            r=r+(n-(r+l));
        }else{
            l=l+(n-(r+l));
        }

        return Math.abs(r-l);
    }
}