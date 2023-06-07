class Solution {
    public int minBitFlips(int start, int goal) {
        int minFlips = 0;
        
        for(int i=0;i<32;i++){
            boolean ithBitOfStartNum = false;
            boolean ithBitOfGoalNum = false;
            
            if((start & (1 << i)) != 0){
                // It means it is set
                ithBitOfStartNum = true;
            }
            
            if((goal & (1 << i)) != 0){
                // It means it is set
                ithBitOfGoalNum = true;
            }
            
            if(ithBitOfGoalNum == true){
                if(ithBitOfStartNum == false){
                    minFlips++;
                }
            }
            else{
                if(ithBitOfStartNum == true){
                    minFlips++;
                }
            }
        }
        
        return minFlips;
    }
}