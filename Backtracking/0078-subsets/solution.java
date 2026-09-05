class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num : nums){
            int size = result.size();
            for(int i = 0; i < size; i++){
                ArrayList<Integer> currentSet = new ArrayList<>(result.get(i));
                currentSet.add(num);
                result.add(currentSet);
            }
        }
        return result;


    }
}