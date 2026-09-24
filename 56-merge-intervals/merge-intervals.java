class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==0 || n==1) return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int i = 1;
        while(i<n){
            if(end < intervals[i][0]){
                list.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                end = Math.max(end,intervals[i][1]);
            }
           i++;
        }  
        list.add(new int[]{start,end});
        int s = list.size();
        int[][] result = new int[s][2];
        int j = 0;
        for(int[] arr:list){
            result[j][0] = arr[0];
            result[j][1] = arr[1];
            j++;
        }
       return result;
    }
}