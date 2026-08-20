class Solution {
    public int[] resultArray(int[] nums) {
        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int a = 0;
        int b = 0;
        for(int i=2;i<nums.length;i++){
          if(arr1[a]>=arr2[b]){
            a++;
            arr1[a] = nums[i];
          }else{
            b++;
            arr2[b] = nums[i];
          }
        }
        int x = 0;
        for(int j = a+1;j<nums.length;j++){
            arr1[j] = arr2[x];
            x++;
        }
        return arr1;
    }
}