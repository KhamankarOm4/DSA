class Solution(object):
    def minimumTeachings(self, n, languages, friendships):
        """
        :type n: int
        :type languages: List[List[int]]
        :type friendships: List[List[int]]
        :rtype: int
        """
        m = len(languages)
        # Convert each user's languages to a set
        lang_sets = [set(l) for l in languages]
        
        # Step 1: find bad friendships
        bad_users = set()
        for u, v in friendships:
            u -= 1
            v -= 1
            if lang_sets[u].intersection(lang_sets[v]):
                continue  # they can already talk
            bad_users.add(u)
            bad_users.add(v)
        
        # Step 2: check best language to teach
        res = float("inf")
        for L in range(1, n + 1):
            know_L = sum(1 for user in bad_users if L in lang_sets[user])
            res = min(res, len(bad_users) - know_L)
        
        return res