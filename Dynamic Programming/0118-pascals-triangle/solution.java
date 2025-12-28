class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resMat = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1; j < i; j++){
                int value = resMat.get(i-1).get(j-1) + resMat.get(i-1).get(j);
                row.add(value);
            }
            if(i > 0) row.add(1);
            resMat.add(row);
        }
        return resMat;
    }
}