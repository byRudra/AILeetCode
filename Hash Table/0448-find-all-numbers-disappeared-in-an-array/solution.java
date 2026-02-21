class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int marker[] = new int[nums.length];
        for(int num : nums){
            marker[num - 1] = 1;
        }
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < marker.length; i++) {
            if (marker[i] == 0) {
                result.add(i + 1); 
            }
        }

        return result;
    }
}