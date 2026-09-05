class Solution {
    public int candy(int[] ratings) {
        int arr[] = new int[ratings.length];

        // Default 1 to all
        for(int i = 0; i < ratings.length; i++){
            arr[i] = 1;
        }

        // Forward Pass 
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i - 1] < ratings[i]){
                arr[i] = arr[i - 1] + 1;
            }
        }

        // Backward Pass
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i + 1] < ratings[i]){
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        // Sum Candy
        int sum = 0;
        for(int candy : arr){
            sum += candy;
        }
        
        return sum;
    }
}