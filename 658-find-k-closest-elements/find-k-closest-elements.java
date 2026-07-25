class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0;
        int j = arr.length-1;
        while((j-i)>=k){
            if(Math.abs(arr[i]-x)>Math.abs(arr[j]-x)){
                i++;
            }else{
                j--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int idx=i;idx<=j;idx++){
            list.add(arr[idx]);
        }
        return list;
    }
}