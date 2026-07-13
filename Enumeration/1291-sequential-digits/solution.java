class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        String digits = "123456789";
        for(int len = 2; len < 10; len++){
            for(int start = 0; start+len < 10; start++){
                int num = Integer.parseInt(digits.substring(start, start+len));

                if (num >= low && num <= high) result.add(num);
            }
        }
        return result;
    }
}