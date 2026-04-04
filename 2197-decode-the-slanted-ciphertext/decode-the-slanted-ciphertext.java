class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder sb = new StringBuilder();
       int n = encodedText.length();
       if(rows== 0) return "";
       if(n == 0) return "";

       int cols = n/rows;

       char[][] mat = new char[rows][cols];
       int idx = 0;
       for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            mat[i][j]=encodedText.charAt(idx++);
        }
       } 

       for(int startcol=0;startcol<cols;startcol++){
        int i=0,j=startcol;
        while(i<rows && j<cols){
          sb.append(mat[i][j]);
          i++;
          j++;
        }
       }

        int end=sb.length()-1;
        while(end>=0 && sb.charAt(end)==' '){
            end--;
        }

        return sb.substring(0,end+1);
    }
}