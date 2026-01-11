class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        String s = String.valueOf(x);
        String reversed = new StringBuilder(s).reverse().toString();

        return s.equals(reversed);
    }
}
