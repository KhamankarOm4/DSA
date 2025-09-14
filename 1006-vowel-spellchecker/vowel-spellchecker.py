class Solution(object):
    def spellchecker(self, wordlist, queries):
        """
        :type wordlist: List[str]
        :type queries: List[str]
        :rtype: List[str]
        """
        def devowel(word):
            return re.sub('[aeiou]', '*', word)
        
        exact = set(wordlist)
        case_insensitive = {}
        vowel_error = {}
        
        for word in wordlist:
            lower = word.lower()
            if lower not in case_insensitive:
                case_insensitive[lower] = word
            masked = devowel(lower)
            if masked not in vowel_error:
                vowel_error[masked] = word
        
        res = []
        for query in queries:
            if query in exact:
                res.append(query)
            else:
                lower = query.lower()
                if lower in case_insensitive:
                    res.append(case_insensitive[lower])
                else:
                    masked = devowel(lower)
                    res.append(vowel_error.get(masked, ""))
        return res