class Solution {
    public String frequencySort(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(int i=0;i<s.length();i++){
            map.put((s.charAt(i)-'a'),map.getOrDefault((s.charAt(i)-'a'),0)+1);
        }

        for(int x:map.keySet()){
            heap.add(new int[]{x,map.get(x)});
        }
        
        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()){
           int[] temp = heap.poll();
           int k = temp[1];
           while(k>0){
            sb.append((char)('a'+temp[0]));
            k--;
           }
        }
        return sb.toString();
    }
}