class Solution {
    public boolean isAnagram(String s, String t) {
        int array[] = new int[26];
        for (char ch : s.toCharArray()) {
            array[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            if (array[ch - 'a'] == 0)
                return false;
            array[ch - 'a']--;
        }
        if (s.length() == t.length())
            return true;
        return false;
    }
}