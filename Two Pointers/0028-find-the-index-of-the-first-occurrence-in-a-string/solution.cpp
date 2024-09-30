class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = haystack.length(), m = needle.length();

        if (m == 0) return 0;
        if (m > n) return -1;

        for (int i = 0; i <= n - m; i++){
            if (haystack.substr(i,m) == needle) return i;
        }

        return -1;
    }
};