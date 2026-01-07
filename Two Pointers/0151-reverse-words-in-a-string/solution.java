class Solution {
    public String reverseWords(String s) {
        StringBuilder reversedString = new StringBuilder("");

        s = s.trim();

        int index = s.length() - 1;

        while(index >= 0){
            int length = 0;
            while(index >= 0 && s.charAt(index) != ' '){
                index--;
                length++;
            }
            reversedString.append(s.substring(index+1,index+1+length));
            reversedString.append(" ");
            if(index < 0)break;
            while(index >= 0 && s.charAt(index) == ' '){
                index--;
            }
        }
        return reversedString.toString().trim();
    }
}