class Solution {
    public int candy(int[] ratings) {
        int numberOfChildren = ratings.length;
        int [] candies = new int[numberOfChildren];
        Arrays.fill(candies, 1);
        
        for(int i=1;i<numberOfChildren;i++){
            if(ratings[i-1] < ratings[i]){
                candies[i] = candies[i-1] + 1;
            }
        }
        
        for(int i=numberOfChildren-1;i>0;i--){
            if(ratings[i-1]>ratings[i]){
			    candies[i-1] = Math.max(candies[i]+1,candies[i-1]);
            }
        }
        
        int minNumberOfCandies = 0;
        
        for(int i=0;i<numberOfChildren;i++){
            minNumberOfCandies += candies[i];
        }
        
        return minNumberOfCandies;
    }
}