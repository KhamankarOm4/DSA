class Solution:
    def maxFreqSum(self, s: str) -> int:
        freq = [0]*26
        for ch in s:
          freq[ord(ch)-ord('a')]+=1

        vowels = set('aeiou')
        max_vowel = 0
        max_cons = 0
        for i in range(26):
            ch = chr(i + ord('a'))
            if ch in vowels:
                if freq[i] > max_vowel:
                    max_vowel = freq[i]
            else:
                if freq[i] > max_cons:
                    max_cons = freq[i]

        return max_vowel + max_cons


