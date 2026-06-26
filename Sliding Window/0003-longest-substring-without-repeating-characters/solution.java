class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        Set<Character> seenCharacters = new HashSet<>();
        int windowStart = 0, longestSubSequence = 0;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            char currChar = s.charAt(windowEnd);

            while(seenCharacters.contains(currChar)){
                seenCharacters.remove(s.charAt(windowStart));
                windowStart++;
            }
            seenCharacters.add(currChar);
            longestSubSequence = Math.max(longestSubSequence,windowEnd - windowStart+1);
        }
        return longestSubSequence;

    }
}