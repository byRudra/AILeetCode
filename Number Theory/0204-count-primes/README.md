# 204. Count Primes

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/count-primes/)

`Array` · `Math` · `Enumeration` · `Number Theory` · `Primality Test` · `Sieve Theory` · `Prime Number Sieve`

## Intuition
Prime numbers are defined by having no divisors other than 1 and themselves.  
The classic way to find all primes below a limit is the Sieve of Eratosthenes:  
mark every multiple of each discovered prime as composite, then count the unmarked indices.  
This approach is linearithmic in practice and fits the 5 × 10⁶ bound comfortably.

## Approach
1. Handle the trivial cases `n ≤ 2` → 0 primes.  
2. Create a boolean array `isComposite` of length `n`.  
3. For each integer `i` from 2 up to `√n`:
   * If `i` is not marked composite, it is prime.  
   * Mark all multiples of `i` starting at `i*i` (the first unmarked multiple) as composite.  
4. After sieving, iterate over the array and count indices that remain `false`.  
   These correspond to primes 2 and above.  
5. Subtract 2 from the count to exclude the indices 0 and 1, which were never marked but are not primes.

## Complexity
- **Time:** O(n log log n) – each composite is marked once, and the inner loop runs only for primes up to √n.  
- **Space:** O(n) – a boolean array of size `n` stores composite flags.

## Solution (java)

```java
class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int count = 0;
        boolean isComposite[] = new boolean[n];
        for(int i = 2; i*i < n; i++){
            if(!isComposite[i]){
                for(int j = i*i; j < n; j += i){
                    isComposite[j] = true;
                }
            }
        }

        for(boolean check : isComposite){
            if(!check) count++;
        }
        return count - 2;
    }
}
```

---

**Runtime** 619 ms · **Memory** 80 MB

<sub>Synced by AILeetHub on 2026-09-03.</sub>
