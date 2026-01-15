# 1910. Remove All Occurrences of a Substring

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/remove-all-occurrences-of-a-substring/)

`String` · `Stack` · `Simulation`

## Intuition  
The task is to repeatedly remove the leftmost occurrence of a given substring until none remain.  
Because the removal can create new occurrences that span the boundary of the deleted part, the process must be repeated until the string stabilises. A simple linear scan that deletes each match as soon as it is found is sufficient for the given limits.

## Approach  
1. Create a mutable `StringBuilder` containing the original string.  
2. While the builder still contains the target substring (`part`):  
   * Find the first index of `part` using `indexOf`.  
   * Delete the characters from that index up to `index + part.length()`.  
3. Return the builder’s content as a string.  
The loop guarantees that the leftmost occurrence is removed each iteration, and the repeated `indexOf` calls automatically handle any new occurrences that appear after a deletion.

## Complexity  
- **Time:** O(n²) – each `indexOf` scans the current string from the beginning, and in the worst case we may delete one character per iteration.  
- **Space:** O(n) – the `StringBuilder` holds a copy of the string, which can be up to the original length.

## Solution (java)

```java
class Solution {
    // public String removeOccurrences(String s, String part) {
    //     StringBuilder finalString = new StringBuilder();
    //     int partLength = part.length();
        
    //     for(int i = 0; i < s.length(); i++){
    //         finalString.append(s.charAt(i));
    //         if(finalString.length() >= partLength){
    //             int lastPart = finalString.length() - partLength,finalString.length();
    //             if(finalString.substring(lastPart).equals(part)){
    //                 finalString.delete(lastPart);
    //             }
    //         }
    //     }
    //     return finalString.toString();
    // }
    // better approach simple
    public String removeOccurrences(String s, String part) {
        StringBuilder finalString = new StringBuilder(s);
        int partLength = part.length();
        int index = finalString.indexOf(part);
        while(index != -1){
            finalString.delete(index, index + partLength);
            index = finalString.indexOf(part);
        }
        return finalString.toString();
    }
}
```

---

**Runtime** 1 ms · **Memory** 42.9 MB

<sub>Synced by AILeetHub on 2026-01-15.</sub>
