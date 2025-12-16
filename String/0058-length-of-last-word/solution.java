class Solution {
    public int lengthOfLastWord(String s) {
        int ending = s.length() - 1;

        while(ending >= 0 && s.charAt(ending) == ' ') ending--;

        int starting = ending;

        while(starting >=0  && s.charAt(starting) != ' ') starting --;

        return ending - starting;
    }
}