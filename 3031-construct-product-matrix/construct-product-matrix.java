class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] p = new int[n][m];
        long pref = 1,suff=1;

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                p[i][j] =(int)pref;
                pref=(pref*grid[i][j])%12345;
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                p[i][j]=(int)(p[i][j]*suff)%12345;
                suff = (suff*grid[i][j])%12345;
            }
        }

        return p;
        
    }
}