// class Solution {
//     public String mergeAlternately(String word1, String word2) {
//         String result = "";
//         int i = 0, j = 0;
//         boolean turnWord = true;
//         while (i < word1.length() && j < word2.length()) {
//              if (turnWord) {
//                 result += word1.charAt(i);
//                 i++;
//             } else {
//                 result += word2.charAt(j);
//                 j++;
//             }

//             turnWord = !turnWord;
//         }
//         while (i < word1.length()) {
//             result += word1.charAt(i);
//             i++;
//         }
//         while (j < word2.length()) {
//             result += word2.charAt(j);
//             j++;
//         }
//         return result;
//     }
// }

//Better approach
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < word1.length() || i < word2.length()) {

            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }

            i++;
        }

        return result.toString();
    }
}