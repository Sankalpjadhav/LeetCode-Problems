class Solution {
    public int distanceTraveled(int maintank, int additionalTank) {
        int ans = 0;
        
        while(maintank != 0){
            if(maintank < 5){
                ans += maintank*10;
                maintank = 0;
            }
            else{
                maintank -= 5;
                ans += 50;
                if(additionalTank >= 1){
                    maintank += 1;
                    additionalTank -= 1;
                }
            }
        }
        
        return ans;
    }
}