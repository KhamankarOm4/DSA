class Solution {
    public int findComplement(int num) {
        if(num==0) return 1;
        int mask = num;
        for(int i=0;i<=4;i++){
            mask |= mask >>(1<<i);
        }

        return ~num&mask;
    }
}