class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
       int n = points.length;
       int count = 0;
       if(n==0 || n==1) return n;
       int prev = 0;
        for(int i=1;i<n;i++){
            if(points[prev][1]>=points[i][0] && points[prev][1]<=points[i][1]){
                count++;
            }else{
               prev= i;
            }
        }
        return n-count;
    }
}