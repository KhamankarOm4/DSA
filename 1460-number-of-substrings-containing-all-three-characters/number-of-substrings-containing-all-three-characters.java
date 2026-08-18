class Solution {
    public int numberOfSubstrings(String s) {
        int right = 0;
        HashMap<Character , Integer> map = new HashMap<>();

        int count = 0;

        while(right<s.length()){
            char ch = s.charAt(right);
            map.put(ch , right);

            if(map.size() == 3){
                int minIndex = Collections.min(map.values());
                count += minIndex + 1;
            }

            right++;
        }


        return count;
    }
}