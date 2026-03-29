# 596. Classes With at Least 5 Students

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/classes-with-at-least-5-students/)

`Database`

## Intuition  
The goal is to identify classes that appear at least five times in the table, because each row represents a distinct student enrollment. Counting occurrences per class and keeping those with a count ≥ 5 directly yields the desired result.

## Approach  
1. **Group by class** – Using `groupby('class')` clusters all rows belonging to the same class.  
2. **Filter groups** – Apply `filter(lambda x: len(x) >= 5)` to keep only groups whose size is five or more.  
3. **Extract class names** – From the filtered groups, select the `'class'` column.  
4. **Remove duplicates** – Since a class may appear in multiple rows, `drop_duplicates()` ensures each qualifying class appears once.  
5. **Return as DataFrame** – Convert the resulting Series back to a DataFrame with `to_frame()` so the output matches the expected format.

This pipeline leverages pandas’ efficient grouping and filtering mechanisms, producing the list of classes with at least five students in a single pass.

## Complexity  
- **Time:** O(n) – each row is processed once during grouping and filtering.  
- **Space:** O(k) – where k is the number of distinct classes that meet the threshold, for storing the result.

## Solution (pythondata)

```python
import pandas as pd

def find_classes(courses: pd.DataFrame) -> pd.DataFrame:
    result = courses.groupby('class').filter(lambda x: len(x) >= 5)['class'].drop_duplicates()
    return result.to_frame()
```

---

**Runtime** 252 ms · **Memory** 69.1 MB

<sub>Synced by AILeetHub on 2026-03-29.</sub>
