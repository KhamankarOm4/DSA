class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = new int[m];
        int ans = 0;
        int hasX = 1001;
        for(int i=0;i<n;i++){
            int temp =0;
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X'){
                    arr[j] += 1;
                    hasX = Math.min(hasX,j);
                }else if(grid[i][j]=='Y'){
                    arr[j]-=1;
                }
                temp+=arr[j];
                if(hasX <=j && temp == 0){
                    ans++;
                }
            }
        }
            return ans;
        

    }
}