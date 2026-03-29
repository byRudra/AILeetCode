import pandas as pd

def find_classes(courses: pd.DataFrame) -> pd.DataFrame:
    result = courses.groupby('class').filter(lambda x: len(x) >= 5)['class'].drop_duplicates()
    return result.to_frame()