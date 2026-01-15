class Solution {
    public String findValidPair(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < s.length()-1;i++){
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if(a!=b&& frequency.get(a) == a - '0' && frequency.get(b) == b - '0'){
                return "" + a + b;
            }
        }
        return "";
    }
}