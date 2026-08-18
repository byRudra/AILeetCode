// class Solution {
//     public String longestPalindrome(String s) {
//         String rev = new StringBuilder(s).reverse().toString();
//         int n = s.length();
//         boolean[][] dp = new boolean[n + 1][n + 1];
//         int start = 0;
//         int maxLen = 1;
//         for (int i = 0; i < n; i++) {
//             dp[i][i] = true;
//         }

//         for (int len = 2; len <= n; len++) {
//             for (int i = 0; i +len <= n; i++) {
//                 int j = i + len - 1;

//                 if (s.charAt(i) == s.charAt(j)) {
//                     if (len == 2) {
//                         dp[i][j] = true;
//                     } else {
//                         dp[i][j] = dp[i + 1][j - 1];
//                     }
//                 }
//                 if (dp[i][j] && len > maxLen) {
//                     start = i;
//                     maxLen = len;
//                 }
//             }
//         }
//         return s.substring(start, start + maxLen);

//     }
// }
// TWO POINTERS 

class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;
        for(int i = 0;  i < s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > maxLen){
                maxLen = len;
                start = i - (len -1) / 2;
            }
        }
        return s.substring(start, start+ maxLen);
    }
    private int expand(String s, int left, int right){  
        while(left >=0 && right < s.length()&&s.charAt(left) == s.charAt(right)){
            left --;
            right++;

        }
        return right - left - 1;

    }
}