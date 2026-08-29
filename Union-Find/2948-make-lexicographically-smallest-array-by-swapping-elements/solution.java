class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        //Defining and sorting the order in which the nums are; 

        Integer order[] = new Integer[n];
        for (int i = 0; i < n; i++)
            order[i] = i;

        Arrays.sort(order, (a, b) -> nums[a] - nums[b]);

        int ans[] = new int[n];
        int i = 0;
        while (i < n) {
            int j = i + 1;

            while (j < n && nums[order[j]] - nums[order[j - 1]] <= limit)
                j++;

            int[] vals = new int[j - i];
            for (int k = i; k < j; k++)
                vals[k - i] = nums[order[k]];

            Arrays.sort(order, i, j);

            for (int k = i; k < j; k++)
                ans[order[k]] = vals[k - i];

            i = j;
        }
        return ans;
    }
}