class Solution(object):
    def canBeTypedWords(self, text, brokenLetters):
        """
        :type text: str
        :type brokenLetters: str
        :rtype: int
        """
        broken = set(brokenLetters)
        ct = 0
        
        for word in text.split():
            if all(ch not in broken for ch in word):
                ct += 1
                
        return ct
        