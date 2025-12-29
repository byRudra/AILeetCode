class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();

        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int value = 0;
        int prevVal = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int currVal = romanMap.get(currChar);

            if (currVal <= prevVal) {
                value += currVal;
            } else {
                value += currVal - 2 * prevVal;
            }
            prevVal = currVal;

        }
        return value;
    }
}