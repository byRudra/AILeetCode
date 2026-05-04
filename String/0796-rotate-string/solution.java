class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        String dummy = s + s;
        return dummy.contains(goal) && goal.length() == s.length();
    }
}