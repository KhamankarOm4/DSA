class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String,List<String>> map = new HashMap<>();
       List<List<String>> result = new ArrayList<>();

       for(String s:strs){
        char[] ele = new char[s.length()];
        for(int i=0;i<s.length();i++){
            ele[i]=s.charAt(i);
        }
        Arrays.sort(ele);
        String key = String.valueOf(ele);
        map.computeIfAbsent(key,k->new ArrayList<>()).add(s);
     }

     for(String key:map.keySet()){
        result.add(map.get(key));
     }
     return result;
    }
}