class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int length = s.length();
        boolean [] visited = new boolean[length];
        visited[0] = true;

        int reachable = 0;
        for(int i = 1; i < length; i++){

            if(i - minJump >= 0 && visited[i - minJump ]){
                reachable++;
            }

            if(i - maxJump - 1 >= 0 && visited[i - maxJump - 1]){
                reachable--;
            }
            if(reachable > 0 && s.charAt(i) == '0')
                visited[i] = true;
        }
        return visited[length-1];
    }
}