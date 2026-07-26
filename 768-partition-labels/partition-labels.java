class Solution {
    public List<Integer> partitionLabels(String s) {
       if(s.length()==0) return new ArrayList<>();
       if(s.length()==1) return Arrays.asList(1);
       int[][] arr = new int[26][2];
       for (int i = 0; i < 26; i++) {
            arr[i][0] = (int)1e9; 
            arr[i][1] = -1;     
        }
       for(int i=0;i<s.length();i++){
        arr[s.charAt(i)-'a'][0] = Math.min(arr[s.charAt(i)-'a'][0],i);
        arr[s.charAt(i)-'a'][1] = Math.max(arr[s.charAt(i)-'a'][1],i);
       } 
       List<int[]> intervals = new ArrayList<>();

        for (int[] x : arr) {
            if (x[0] != (int)1e9)
                intervals.add(x);
        }
       Collections.sort(intervals,(a,b)->a[0]-b[0]);
       int start = intervals.get(0)[0];
       int end = intervals.get(0)[1];
       List<Integer> res = new ArrayList<>();
       for(int i=0;i<intervals.size()-1;i++){
          if(end>=intervals.get(i+1)[0]){
            start = Math.min(intervals.get(i)[0],start);
            end = Math.max(intervals.get(i+1)[1],end); 
          }else{
           res.add(end-start+1);
             start = intervals.get(i+1)[0];
             end = intervals.get(i+1)[1];

          }
       }
       res.add(end-start+1);
       return res;
    }
}