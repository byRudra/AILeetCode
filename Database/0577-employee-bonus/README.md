# 577. Employee Bonus

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/employee-bonus/)

`Database`

## Intuition  
We need every employee’s name and the amount of bonus they received, but only for those who earned less than $1,000 or received no bonus at all. A left join naturally preserves all employees while attaching bonus data when it exists, leaving missing bonuses as `NaN`. After the join we can simply filter on the bonus column.

## Approach  
1. Perform a **left merge** of the `employee` DataFrame with the `bonus` DataFrame on `empId`.  
2. The resulting DataFrame contains every employee row, with `bonus` set to `NaN` for those without an entry in the `bonus` table.  
3. Apply a boolean mask that keeps rows where `bonus < 1000` **or** `bonus` is `NaN`.  
4. Select only the `name` and `bonus` columns for the final result.  
The merge guarantees that employees without bonuses are included, and the filter captures both the “< 1000” and “no bonus” conditions in a single step.

## Complexity  
- **Time:** O(n + m) – one pass to merge `n` employees with `m` bonuses and one pass to filter.  
- **Space:** O(n + m) – the merged DataFrame holds all employee rows plus any bonus rows.

## Solution (pythondata)

```python
import pandas as pd

def employee_bonus(employee: pd.DataFrame, bonus: pd.DataFrame) -> pd.DataFrame:
    df = employee.merge(bonus, on="empId", how='left')
    return df[(df['bonus'] < 1000) | (df['bonus'].isna())][['name', 'bonus']]
```

---

**Runtime** 352 ms · **Memory** 68.3 MB

<sub>Synced by AILeetHub on 2026-03-22.</sub>
