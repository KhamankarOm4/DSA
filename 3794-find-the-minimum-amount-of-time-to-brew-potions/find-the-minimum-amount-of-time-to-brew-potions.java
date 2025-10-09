class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long sumSkill = 0;
        for (int s : skill) sumSkill += s;
        long cur = sumSkill * mana[0];
        for (int j = 1; j < m; ++j) {
            long prevPotionDone = cur;
            for (int i = n - 2; i >= 0; --i) {
                prevPotionDone -= (long) skill[i + 1] * mana[j - 1];
                cur = Math.max(prevPotionDone, cur - (long) skill[i] * mana[j]);
            }
            cur += sumSkill * mana[j];
        }
        return cur;
    }
}