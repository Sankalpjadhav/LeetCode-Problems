class Solution {
    public int maxScore(String s) {
        int maxScore = 0;
        int numberOfOnes = 0;
        int n = s.length();
        
        // Count number of Zeros
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1'){
                numberOfOnes++;
            }
        }
        
        int leftCountOfZeros = 0;
        int leftCountOfOnes = 0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == '0'){
                leftCountOfZeros++;
            }
            else{
                leftCountOfOnes++;
            }
            
            maxScore = Math.max(leftCountOfZeros + (numberOfOnes - leftCountOfOnes), maxScore);
        }
        
        return maxScore;
    }
}