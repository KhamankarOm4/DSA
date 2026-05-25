class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for(String s:strs){
            char[] arr = new char[s.length()];
            int i=0;
            for(char c:s.toCharArray()){
              arr[i] = c;
              i++;
            }
            Arrays.sort(arr);
           String key = Arrays.toString(arr);
            map.computeIfAbsent(key,k-> new ArrayList()).add(s);
        }

        for(String key:map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
}