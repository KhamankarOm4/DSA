class Solution {
    public int myAtoi(String s) {
        s = s.strip(); 
        if (s.isEmpty()) return 0;
        
        int sign = 1, i = 0, num = 0;
        int intMin = Integer.MIN_VALUE;
        int  intMax = Integer.MAX_VALUE;
        
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            if (num > (intMax - digit) / 10) {
                return sign == 1 ? intMax : intMin;
            }
            num = num * 10 + digit;
            i++;
        }
        
        return num * sign; 
    }
}