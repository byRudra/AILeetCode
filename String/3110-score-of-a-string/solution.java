class Solution {
    public int scoreOfString(String s) {
      //ascii value->charAt(smtg) is the ascii value
    // int sum=0;
    //   for(int i=0;i<s.length()-1;i++){
    //     sum+=Math.abs(s.charAt(i) - s.charAt(i+1));
    //   }  
    //   return sum;










    int sum=0;

    for(int i=0;i<s.length()-1;i++){
        sum+=Math.abs(s.charAt(i)-s.charAt(i+1));
    }
    return sum;
    }
}