class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        List<Character> vowelList = new ArrayList<>();

        // 1) Extract vowels
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelList.add(c);
            }
        }

        // 2) Sort vowels by ASCII value
        vowelList.sort((a, b) -> Character.compare(a, b));

        // 3) Build result, replacing vowels with sorted ones
        StringBuilder result = new StringBuilder();
        int vi = 0; // vowel index
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                result.append(vowelList.get(vi++));
            } else {
                result.append(c);
            }
        }

        return result.toString();  
    }
}