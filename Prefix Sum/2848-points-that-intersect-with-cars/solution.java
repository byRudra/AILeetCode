class Solution {
    // Using Brute Force
    // ''' 
    // Make a huge boolean array which will store 1 or 0 for visited points
    // make the value at index at value i '1' in the range of the points of car ex [2,5]
    // mark 2, 3, 4, 5 indexs as 1 and then sum the whole array.
    // '''

    // Using HashSet
    // public int numberOfPoints(List<List<Integer>> nums) {
    //     HashSet<Integer> points = new HashSet<>();

    //     for(List<Integer> car : nums){
    //         int start = car.get(0);
    //         int end = car.get(1);

    //         for(int i = start; i <= end; i++){
    //             points.add(i);
    //         }
    //     }

    //     return points.size();
    // }

    // Bettter Approach using "Prefix Sum / Range Marking"
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] diff = new int[102];

        for(List<Integer> car : nums){
            int start = car.get(0);
            int end = car.get(1);
            diff[start] += 1;
            diff[end + 1] -= 1;
        }

        int count = 0;
        int result = 0;
        for(int i = 0; i <= 100; i++){
            count += diff[i];
            if(count > 0){result++;}
        }
        return result;
    }

}