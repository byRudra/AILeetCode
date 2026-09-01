# 3568. Minimum Moves to Clean the Classroom

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/)

`Array` · `Hash Table` · `Bit Manipulation` · `Breadth-First Search` · `Matrix`

## Approach

Accepted medium solution in java.
Relevant topics: Array, Hash Table, Bit Manipulation, Breadth-First Search, Matrix.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (java)

```java
class Solution {
    record State(int r, int c, int e, int mask) {
    }

    public int minMoves(String[] classroom, int E) {
        int m = classroom.length, n = classroom[0].length();
        int sr = 0, sc = 0, k = 0;
        int[][] id = new int[m][n];
        for (int[] x : id)
            java.util.Arrays.fill(x, -1);

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (classroom[r].charAt(c) == 'S') {
                    sr = r;
                    sc = c;
                } else if (classroom[r].charAt(c) == 'L') {
                    id[r][c] = k++;
                }
            }
        }

        int target = (1 << k) - 1;
        boolean[][][][] seen = new boolean[m][n][E + 1][1 << k];

        Queue<State> q = new ArrayDeque<>();

        q.add(new State(sr, sc, E, 0));
        seen[sr][sc][E][0] = true;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                State s = q.poll();

                if (s.mask == target)
                    return moves;

                if (s.e == 0)
                    continue;

                for (int d = 0; d < 4; d++) {
                    int r = s.r + dr[d], c = s.c + dc[d];

                    if (r < 0 || r >= m || c < 0 || c >= n || classroom[r].charAt(c) == 'X')
                        continue;

                    int e = s.e - 1;

                    if (classroom[r].charAt(c) == 'R')
                        e = E;

                    int mask = s.mask;

                    if (id[r][c] != -1)
                        mask |= 1 << id[r][c];
                    if (!seen[r][c][e][mask]) {
                        seen[r][c][e][mask] = true;
                        q.add(new State(r, c, e, mask));
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
```

---

**Runtime** 426 ms · **Memory** 252.4 MB

<sub>Synced by AILeetHub on 2026-09-01.</sub>
