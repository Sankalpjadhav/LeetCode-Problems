class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int totalGas = 0, totalCost = 0;
        
        for(int i=0; i<gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        // If total gas value is less than total cost value, then it is not possible to travel around the circuit
        if(totalGas < totalCost){
            return -1;
        }
        
        int startIndex = 0;
        int remainingGas = 0;
        
        for(int i=0; i<gas.length; i++){
            remainingGas = remainingGas + (gas[i] - cost[i]);
            if(remainingGas < 0){
                startIndex = i+1;
                remainingGas = 0;
            }
        }
        
        return startIndex;
    }
}