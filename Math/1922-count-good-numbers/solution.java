class Solution {
        static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        long pow5 = power(5, even);
        long pow4 = power(4, odd);

        return (int) ((pow5 * pow4) % MOD);
    }

    private long power(long base, long exp) {
        if (exp == 0)
            return 1;

        long half = power(base, exp / 2);
        long result = (half * half) % MOD;

        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        return result;
    }
}