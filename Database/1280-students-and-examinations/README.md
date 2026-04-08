# 1280. Students and Examinations

![Easy](https://img.shields.io/badge/Difficulty-Easy-00b8a3?style=flat-square) [Open on LeetCode](https://leetcode.com/problems/students-and-examinations/)

`Database`

## Approach

Accepted easy solution in pythondata.
Relevant topics: Database.

## Complexity

- **Time:** _not analysed_
- **Space:** _not analysed_

## Solution (pythondata)

```python
# Time: O(n) , Space: O(n) 
import pandas as pd

def students_and_examinations(students: pd.DataFrame, subjects: pd.DataFrame, examinations: pd.DataFrame) -> pd.DataFrame:
    
    df = students.merge(subjects, how='cross')
    examinations.rename(columns={'subject_name':'subject_name2'},inplace=True)
    df_result=df.merge(examinations, how='left', left_on=['student_id','subject_name'], right_on=['student_id','subject_name2'])

    return df_result.groupby(['student_id','student_name','subject_name'], dropna=False)['subject_name2'].count().reset_index(name='attended_exams')
```

---

**Runtime** 355 ms · **Memory** 68.6 MB

<sub>Synced by AILeetHub on 2026-04-08.</sub>
