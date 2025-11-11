// class Solution {
//     public boolean canJump(int[] nums) {
//         // greedy approach

//         int maxJump = 0;

//         // Looping thorugh the array
//         for(int i = 0; i < nums.length; i++){
//             // check if i > maxJump if yes then we cant reach end 
//             if (i > maxJump) return false;

//             // updating the value of maxJump by comparing the max of maxJump and i + nums[i] 
//             // the i + nums[i] tells where the jump will land
//             maxJump = Math.max(maxJump, i + nums[i]);

//             // early stopping if we already have a maxJump > nums.length - 1

//             if(maxJump >= nums.length - 1) return true;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean canJump(int[] nums) {
        // BFS approach (Breadth first search)

        int maxEnd = 0,currEnd = 0;

        // Looping thorugh the array
        for(int i = 0; i < nums.length; i++){
            maxEnd = Math.max(maxEnd, i + nums[i]);
            if(currEnd == i) currEnd = maxEnd;

            if(currEnd >= nums.length - 1) return true;
        }
        return currEnd >= nums.length - 1;
    }
}