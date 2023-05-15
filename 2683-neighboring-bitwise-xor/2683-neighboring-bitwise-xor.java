class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int currentXOR = 0;
        
        for(int num: derived){
            currentXOR ^= num;
        }
        
        return currentXOR == 0;
    }
}

// https://www.youtube.com/watch?v=1bG7yHe79_M