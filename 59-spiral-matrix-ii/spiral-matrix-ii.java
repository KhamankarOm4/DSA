class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
       int top = 0; int bottom = matrix.length-1;
       int left = 0; int right = matrix[0].length-1;
       int x = 1;
       while(top<=bottom && left<=right){

         for(int i=left;i<=right;i++){
            matrix[top][i] = x;
            x++;
         }
         top++;

         for(int j=top;j<=bottom;j++){
            matrix[j][right] = x;
            x++;
         }
         right--;

         if(top<=bottom){
            for(int i=right;i>=left;i--){
               matrix[bottom][i]=x;
               x++; 
            }
            bottom--;
         }

         if(left<=right){
            for(int i=bottom;i>=top;i--){
               matrix[i][left]=x;
               x++; 
            }
            left++;
         }
       } 
       return matrix;
    }
}