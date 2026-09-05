// class Solution {
//     public String countAndSay(int n) {
//         String result = "1";
//         for(int i = 2; i <= n; i++){
//             StringBuilder next = new StringBuilder();
//             int count = 1;

//             for(int j = 1; j < result.length(); j++){
//                 if(result.charAt(j) == result.charAt(j - 1)){
//                     count++;
//                 }
//                 else{
//                     next.append(count);
//                     next.append(result.charAt(j-1));
//                     count = 1;
//                 }
//             }
//             next.append(count);
//             next.append(result.charAt(result.length() - 1));
//             result = next.toString();

//         }
//         return result;
//     }
// }

// Better Approach

class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        return nextTerm(countAndSay(n - 1));
    }

    private String nextTerm(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < len) {
            char c = chars[i];
            int count = 1;
            while (i + count < len && chars[i + count] == c) {
                count++;
            }
            sb.append(count).append(c);
            i += count;
        }
        return sb.toString();
    }
}