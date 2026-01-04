class Solution {
    private boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;

        }
        return true;
    }
    public int sumFourDivisors(int[] nums) {
        int total =0;
        for(int x: nums){
            int p = (int)Math.round(Math.cbrt(x));
            if(p*p*p == x && isPrime(p)){
                total +=1+p+p*p+x;
                continue;
            }

            boolean found = false;
            for(int i=2;i*i<=x;i++){
                if(x%i==0){
                    int j=x/i;
                    if(i!=j && isPrime(i) && isPrime(j)){
                        total +=1+i+j+x;
                    }
                    found = true;
                    break;
                }
            }
        }
        return total;
    }
}