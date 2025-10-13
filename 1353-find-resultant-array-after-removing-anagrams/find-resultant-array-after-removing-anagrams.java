class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        String prevSig = "";
        for (int i = 0; i < words.length; i++) {
            char[] a = words[i].toCharArray();
            Arrays.sort(a);
            String sig = new String(a);
            if (!sig.equals(prevSig)) {
                res.add(words[i]);
                prevSig = sig;
            }
        }
        return res;
    }
}