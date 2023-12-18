class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        int smallestX = Integer.MAX_VALUE;
        int secondSmallestX = smallestX-1;
        int greatestY = Integer.MIN_VALUE;
        int secondGreatestY = greatestY+1;
        
        // Find smallest two numbers
        for(int i=0;i<n;i++){
            int num = nums[i];
            if(num < smallestX){
                secondSmallestX = smallestX;
                smallestX = num;
            }
            else{
                if(num < secondSmallestX){
                    secondSmallestX = num;
                }
            }
        }
        
        // Find greatest two numbers
        for(int i=0;i<n;i++){
            int num = nums[i];
            if(num > greatestY){
                secondGreatestY = greatestY;
                greatestY = num;
            }
            else{
                if(num > secondGreatestY){
                    secondGreatestY = num;
                }
            }
        }
        
        // System.out.println(greatestY+ " -G- "+ secondGreatestY);
        // System.out.println(smallestX+ " -S- "+ secondSmallestX);
        return (greatestY * secondGreatestY) - (smallestX * secondSmallestX);
    }
}