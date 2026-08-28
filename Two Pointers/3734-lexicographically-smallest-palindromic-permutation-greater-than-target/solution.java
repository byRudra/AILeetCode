class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;

        int oddCount = 0, oddChar = -1;
        for (int c = 0; c < 26; c++) {
            if (count[c] % 2 == 1) {
                oddCount++;
                oddChar = c;
            }
        }

        boolean nOdd = (n % 2 == 1);
        if (nOdd && oddCount != 1)
            return "";
        if (!nOdd && oddCount != 0)
            return "";

        int half = n / 2;
        int[] halfCounts = new int[26];
        for (int c = 0; c < 26; c++)
            halfCounts[c] = count[c] / 2;
        char mid = nOdd ? (char) ('a' + oddChar) : 0;

        int[] remaining = halfCounts.clone();
        int bestI = -1, bestChar = -1;
        int[] bestRemaining = null;
        boolean matched = true;

        for (int i = 0; i < half; i++) {
            int t = target.charAt(i) - 'a';

            for (int c = t + 1; c < 26; c++) {
                if (remaining[c] > 0) {
                    bestI = i;
                    bestChar = c;
                    bestRemaining = remaining.clone();
                    break;
                }
            }

            if (remaining[t] == 0) {
                matched = false;
                break;
            }
            remaining[t]--;
        }

                // Case 1: entire first half matched target exactly — check the forced result
        if (matched) {
            String prefix = target.substring(0, half);
            StringBuilder sb = new StringBuilder(prefix);
            if (nOdd) sb.append(mid);
            sb.append(new StringBuilder(prefix).reverse());
            String candidate = sb.toString();
            if (candidate.compareTo(target) > 0) return candidate;
        }

        // Case 2: fall back to the latest break point found
        if (bestI == -1) return "";

        StringBuilder firstHalf = new StringBuilder();
        firstHalf.append(target, 0, bestI);
        firstHalf.append((char) ('a' + bestChar));

        bestRemaining[bestChar]--;
        for (int c = 0; c < 26; c++) {
            for (int k = 0; k < bestRemaining[c]; k++) {
                firstHalf.append((char) ('a' + c));
            }
        }

        StringBuilder result = new StringBuilder(firstHalf);
        if (nOdd) result.append(mid);
        result.append(new StringBuilder(firstHalf).reverse());

        return result.toString();
    }
}