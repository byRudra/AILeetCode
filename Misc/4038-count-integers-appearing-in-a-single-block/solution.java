class Solution {
    public int countSpecialIntegers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> bad = new HashSet<>();
        int prev = -1;

        for(int num : nums){
            if(num != prev && seen.contains(num))
                bad.add(num);
            seen.add(num);
            prev = num;
        }
        return seen.size() - bad.size();
    }   
}