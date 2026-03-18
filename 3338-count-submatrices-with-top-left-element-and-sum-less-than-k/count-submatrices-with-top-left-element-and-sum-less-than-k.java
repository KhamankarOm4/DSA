class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        int[][] px = new int[n+1][m+1];

    for(int i=0;i<n+1;i++){
        px[i][0]=0;}

    for(int i=0;i<m+1;i++){
        px[0][i]=0;}

    for(int i=1;i<n+1;i++){
        for(int j=1;j<m+1;j++){
            px[i][j]=grid[i-1][j-1]+px[i][j-1]+px[i-1][j]-px[i-1][j-1];
            if(px[i][j]<=k){
                count += 1;
            }
        }
    }
        return count;
    }
}