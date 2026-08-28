class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int remaining[] = new int[26];
        for(char ch : s.toCharArray()) remaining[ch - 'a']++;

        int bestI = -1, bestChar = -1;
        int [] bestRemaining = null;

        for(int i = 0; i < n; i++){
            int t = target.charAt(i) - 'a';
            for(int c = t + 1; c < 26; c++){
                if(remaining[c] > 0){
                    bestI = i;
                    bestChar = c;
                    bestRemaining = remaining.clone();
                    break;
                }
            }
            if(remaining[t] == 0) break;
            remaining[t]--;
        }

        if (bestI == -1) return "";

        StringBuilder result = new StringBuilder();
        result.append(target, 0, bestI);
        result.append((char)('a' + bestChar));
        bestRemaining[bestChar]--;
        for(int i = 0; i < 26; i++){
            for(int k = 0; k < bestRemaining[i]; k++){
                result.append((char)('a' + i));
            }
        }

        return result.toString();
    }
}