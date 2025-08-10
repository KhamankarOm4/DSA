import java.util.Arrays;
class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = countDigits(n);
        for (int i = 0; i < 31; i++) { 
            int power = 1 << i;
            if (countDigits(power).equals(target)) {
                return true;
            }
        }
        return false;
    }

     private String countDigits(int n) {
        char[] ar = String.valueOf(n).toCharArray();
        Arrays.sort(ar);
        return new String(ar);
    }
}