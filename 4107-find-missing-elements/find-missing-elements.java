class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int m = Integer.MAX_VALUE;
        int n = Integer.MIN_VALUE;
        for(int num:nums){
            m = Math.min(m,num);
            n = Math.max(n,num);
            set.add(num);
        }
        for(int i=m+1;i<n;i++){
           if(!set.contains(i)){
            list.add(i);
           }
        }
        return list;
    }
}