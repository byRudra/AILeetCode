class Solution {
    // public String removeOccurrences(String s, String part) {
    //     StringBuilder finalString = new StringBuilder();
    //     int partLength = part.length();
        
    //     for(int i = 0; i < s.length(); i++){
    //         finalString.append(s.charAt(i));
    //         if(finalString.length() >= partLength){
    //             int lastPart = finalString.length() - partLength,finalString.length();
    //             if(finalString.substring(lastPart).equals(part)){
    //                 finalString.delete(lastPart);
    //             }
    //         }
    //     }
    //     return finalString.toString();
    // }
    // better approach simple
    public String removeOccurrences(String s, String part) {
        StringBuilder finalString = new StringBuilder(s);
        int partLength = part.length();
        int index = finalString.indexOf(part);
        while(index != -1){
            finalString.delete(index, index + partLength);
            index = finalString.indexOf(part);
        }
        return finalString.toString();
    }
}