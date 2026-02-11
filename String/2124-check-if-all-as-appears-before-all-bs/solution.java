class Solution {
    public boolean checkString(String s) {

        int count = 0;
        for (int c : s.toCharArray()) {
            if (c == 'b') {
                count++;
            } else if (count != 0) {
                return false;
            }
        }
        return true;
    }
}