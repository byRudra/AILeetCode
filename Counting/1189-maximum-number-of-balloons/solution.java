// class Solution {
//     public int maxNumberOfBalloons(String text) {
//         HashMap<Character, Integer> listChar = new HashMap<>();
//         for(char ch : text.toCharArray()){
//             listChar.put(ch, listChar.getOrDefault(ch, 0) + 1);
//         }
//         int b = listChar.getOrDefault('b', 0);
//         int a = listChar.getOrDefault('a', 0);
//         int l = listChar.getOrDefault('l', 0) / 2;
//         int o = listChar.getOrDefault('o', 0) / 2;
//         int n = listChar.getOrDefault('n', 0);

//         return Math.min(
//             Math.min(
//                 Math.min(b,a),
//                 Math.min(l,o)
//             ),
//             n
//         );
//     }
// }

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];

        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }

        return Math.min(
            Math.min(freq['b' - 'a'], freq['a' - 'a']),
            Math.min(
                Math.min(freq['l' - 'a'] / 2,
                         freq['o' - 'a'] / 2),
                freq['n' - 'a']
            )
        );
    }
}