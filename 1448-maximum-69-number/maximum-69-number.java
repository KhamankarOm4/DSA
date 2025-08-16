class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        int[] arr = new int[str.length()];
        for(int i=0;i<=str.length()-1;i++){
            arr[i] = Character.getNumericValue(str.charAt(i));
        }
        for(int j=0;j<=arr.length-1;j++){
            if(arr[j]==6){
                arr[j] = 9;
                int number = 0;
                for(int digit : arr){
                    number = number * 10 + digit;
                }
                return number;
            }
        }
        return num;
    }
}