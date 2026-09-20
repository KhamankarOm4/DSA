class Solution {
    public int reverseDegree(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int x = 26;
        for(char c = 'a'; c <= 'z'; c++){
            map.put(c,x);
            x--;
        }
        int sum = 0;
        for(int i=0;i<s.length();i++){
          char c = s.charAt(i);
          sum += map.get(c)*(i+1);
        }
        return sum;
    }
}