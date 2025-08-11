MOD = 10**9 + 7

def modinv(x):
   return pow(x, MOD - 2, MOD)
    
def powers_of_two(n):
    res = []
    p = 1
    while n > 0:
        if n & 1:
            res.append(p)
        p <<= 1
        n >>= 1
    return res

class Solution(object):

    def productQueries(self, n, queries):
        """
        :type n: int
        :type queries: List[List[int]]
        :rtype: List[int]
        """
        powers = powers_of_two(n) 
        m = len(powers)
        
       
        prefix = [0] * m
        prefix[0] = powers[0] % MOD
        for i in range(1, m):
            prefix[i] = (prefix[i-1] * powers[i]) % MOD

        results = []
        for l, r in queries:
            if l == 0:
                results.append(prefix[r])
            else:
                results.append((prefix[r] * modinv(prefix[l-1])) % MOD)
        return results