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
        if(!map.containsKey(key)){
            List<String> arr = new ArrayList<>();
            arr.add(s);
            map.put(key,arr);
        }else{
            List<String> arr = map.get(key);
            arr.add(s);
            map.put(key,arr);
        }
     }

     for(String key:map.keySet()){
        result.add(map.get(key));
     }
     return result;
    }
}