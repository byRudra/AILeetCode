class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int start = 0;
        int kCount = 0;
        int ansStart = -1;
        int ansLength = Integer.MAX_VALUE;
        for (int end = 0; end < s.length(); end++) {
            if (s.charAt(end) == '1')
                kCount++;

            while (kCount > k) {
                if (s.charAt(start) == '1')
                    kCount--;
                start++;
            }

            while (kCount == k && s.charAt(start) == '0')
                start++;

            if (kCount == k && s.charAt(end) == '1') {
                int length = end - start + 1;
                String current = s.substring(start, end + 1);
                if (ansLength > length || (length == ansLength
                        && current.compareTo(s.substring(ansStart, ansStart + ansLength)) < 0)) {

                    ansLength = length;
                    ansStart = start;
                }
            }
        }
        return ansStart == -1 ? "" : s.substring(ansStart, ansStart + ansLength);

    }
}