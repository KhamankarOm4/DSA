class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int end = Integer.MIN_VALUE;
        int remove = 0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        
        for(int i=0;i<intervals.length;i++){

            if(end<=intervals[i][0]){
                end = intervals[i][1];
            }else{
                remove++;
            }

        }
        return remove;
    }
}