class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resultContainer = new HashMap<>();

        for (String word : strs) {
            char ch[] = word.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            resultContainer.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(resultContainer.values());
    }
}