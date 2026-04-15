// class Solution {
//     public int closestTarget(String[] words, String target, int startIndex) {
//         int closest = Integer.MAX_VALUE;
//         for(int i = 0; i < words.length; i++){
//             if(words[i].equals(target)){
//                 int dist = Math.abs(i - startIndex);
//                 closest = Math.min(closest, Math.min(dist, words.length - dist));
//             }
//         }
//         return closest == Integer.MAX_VALUE ? -1 : closest;
//     }
// }

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        for(int i = 0; i < n; i++){
            int forward = (i + startIndex) % n;
            int backward = (startIndex - i + n) % n;
            if(words[forward].equals(target) || words[backward].equals(target)) return i;

        }
        return -1;
    }
}