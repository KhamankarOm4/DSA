class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int x:map.keySet()){
            heap.add(new int[]{x,map.get(x)});
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = heap.poll()[0];
        }
        return res;
    }
}