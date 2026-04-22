class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for(String q : queries){
            for(String p : dictionary){
                if(isValid(q, p)){
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }
    private boolean isValid(String q, String p){
        int diff = 0;
        for(int i = 0; i < q.length(); i++){
            if(q.charAt(i) != p.charAt(i)){
                diff++;
            }
        }
        return diff > 2 ? false : true; 
    }
}