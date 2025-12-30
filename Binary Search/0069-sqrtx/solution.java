// Linear search till x / 2
// class Solution {
//     public int mySqrt(int x) {
//         if (x < 2) return x;

//         for (int i = 0; i <= x / 2; i++) {
//             long curr = (long) i * i;
//             long next = (long) (i + 1) * (i + 1);

//             if (curr == x) return i;
//             if (next == x) return i + 1;
//             if (curr < x && x < next) return i;
//         }
//         return 0;
//     }
// }

// Binary Search
class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int startRoot = 0;
        int endRoot = x / 2;
        int answer = 0;

        while (startRoot <= endRoot) {
            int midRoot = startRoot + (endRoot - startRoot) / 2;
            long square = (long) midRoot * midRoot;

            if (square == x) {
                return midRoot;
            } else if (square < x) {
                answer = midRoot;       
                startRoot = midRoot + 1;
            } else {
                endRoot = midRoot - 1;
            }
        }
        return answer;
    }
}
