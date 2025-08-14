class Solution {
    public String largestGoodInteger(String num) {
      String max = "";

        for (int ii = 0; ii <= num.length() - 3; ii++) {
            String s = num.substring(ii, ii + 3);
            if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2)) {
                if (max.isEmpty() || s.compareTo(max) > 0) {
                    max = s;
                }
            }
        }
        return max;   
    }
}