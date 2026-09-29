class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        int x = n/3;
        for(int key:map.keySet()){
            if(map.get(key)>x){
                list.add(key);
            }
        }
        return list;
    }
}