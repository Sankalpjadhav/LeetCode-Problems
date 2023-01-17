class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int countOfOnes = 0;
        int flips = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                countOfOnes++;
            }
            else{
                // ch = '0'
                if(countOfOnes == 0){
                    continue;
                }
                else{
                    // count of 1's is not zero, that means this char is potential candidate to flip
                    flips++;
                }
            }
            
            // Above we were trying to flip O's, but number of 1 counts are less, so we will flip 1's instead.
            flips = Math.min(flips, countOfOnes);
        }
        
        return flips;
    }
}