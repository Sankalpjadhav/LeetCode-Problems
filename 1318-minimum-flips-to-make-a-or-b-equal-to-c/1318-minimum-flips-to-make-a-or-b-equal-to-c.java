class Solution {
    public int minFlips(int a, int b, int c) {
        int numberOfOperations = 0;
        
        for(int i=0;i<32;i++){
            boolean ithBitOfA = false;
            boolean ithBitOfB = false;
            boolean ithBitOfC = false;
            
            // Check if ith bit of a , b and c are set
            if((a & (1 << i)) != 0){
                ithBitOfA = true;
            }
            if((b & (1 << i)) != 0){
                ithBitOfB = true;
            }
            if((c & (1 << i)) != 0){
                ithBitOfC = true;
            }
            
            if(ithBitOfC == true){
                // Here we want ith bit of A | ith bit of B == ith bit of C
                if(ithBitOfA == false && ithBitOfB == false){
                    numberOfOperations++;
                }
                else{
                    // Do nothing since we get ith bit of a | ith bit of b == ith bit of c
                }
            }
            else{
                if(ithBitOfA == true && ithBitOfB == true){
                    // We need to flip both the bits
                    numberOfOperations+=2;
                }
                else if(ithBitOfA == true || ithBitOfB == true){
                    numberOfOperations++;
                }
            }
        }
        
        return numberOfOperations;
    }
}