class Solution {
    public int findMinArrowShots(int[][] points) {
       Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1]));
       int prev = 0;
       int count = 0;
       for(int i =1;i<points.length;i++){
         if(points[i][0]<=points[prev][1] && points[i][1]>=points[prev][1]){
            count++;
         }else{
            prev = i;
         }
       } 
      return points.length - count;

    }
}