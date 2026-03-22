import pandas as pd

def employee_bonus(employee: pd.DataFrame, bonus: pd.DataFrame) -> pd.DataFrame:
    df = employee.merge(bonus, on="empId", how='left')
    return df[(df['bonus'] < 1000) | (df['bonus'].isna())][['name', 'bonus']]