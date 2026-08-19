class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<reservedSeats.length;i++){
            map.computeIfAbsent(reservedSeats[i][0],k-> new ArrayList<>()).add(reservedSeats[i][1]);
        }
        int count = (n-map.size())*2;
        for(List<Integer> list:map.values()){
                int c = 0;
                boolean f1 = false;
                boolean f2 = false;
                 if(!list.contains(2) && !list.contains(3) && !list.contains(4) && !list.contains(5)){
                    c++;
                    f1 = true;
                 }
                 if(!list.contains(6) && !list.contains(7) && !list.contains(8) && !list.contains(9)){
                    c++;
                    f2 = true;
                 } 
                 
                 if(!list.contains(4) && !list.contains(5) && !list.contains(6) && !list.contains(7) && !f1 && !f2){
                    c++;
                 }
                    count += c;
        }
      return count;
    }
}