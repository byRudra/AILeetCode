class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int) 1e9 + 7;
        int[] right = new int[n + 1];
        int[] left = new int[n + 1];
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            right[i + 1] = arr[i];
        }
        int res = 0;

        for (int i = 1; i <= n; i++) {
            int curr = right[i];
            int j = i - 1;

            while (right[j] >= curr) {
                j = left[j];
            }
            left[i] = j;
            sum[i] = sum[j] + curr * (i - j);
            res = (res + sum[i]) % mod;
        }
        return res;
    }
}