class Solution {
    public boolean judgeCircle(String moves) {
        int[] arr = new int[2];

        for(char c: moves.toCharArray()){
            if(c == 'U'){
                arr[0]++;
            }else if(c == 'D'){
                arr[0]--;
            }else if(c == 'L'){
                arr[1]++;
            }else if(c == 'R'){
                arr[1]--;
            }else{
                continue;
            }

        }

        if(arr[0]==0 && arr[1]==0){
            return true;
        }else{
            return false;
        }
        
    }
}