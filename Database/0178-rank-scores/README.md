# 178. Rank Scores

![Medium](https://img.shields.io/badge/Difficulty-Medium-ffc01e?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/rank-scores/)

`Database`

## Intuition  
The goal is to assign a dense rank to each score: the highest score gets rank 1, equal scores share the same rank, and the next distinct score receives the next integer. Pandas’ `rank` method with `method='dense'` implements exactly this logic, while `ascending=False` ensures the ranking is from high to low.

## Approach  
1. **Rank Calculation** – Apply `scores['score'].rank(method='dense', ascending=False)` to compute the rank for every row. The result is a floating‑point rank; converting to `int` yields the required integer rank.  
2. **Projection & Ordering** – Keep only the `score` and `rank` columns and sort them in descending order of `score` with `sort_values`.  
3. **Return** – The function returns the reordered DataFrame, matching the expected output format.

This leverages vectorized pandas operations, avoiding explicit loops and manual sorting logic.

## Complexity  
- **Time:** O(n log n) – ranking and sorting each require a sort over the `n` rows.  
- **Space:** O(n) – the rank column and the sorted result store one value per row.

## Solution (pythondata)

```python
import pandas as pd

def order_scores(scores: pd.DataFrame) -> pd.DataFrame:
    scores['rank'] = scores['score'].rank(method='dense', ascending=False).astype(int)
    return scores[['score','rank']].sort_values('score',ascending = False)
```

---

**Runtime** 295 ms · **Memory** 68.4 MB

<sub>Synced by AILeetHub on 2026-03-25.</sub>
