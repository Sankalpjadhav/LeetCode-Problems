class Solution {
    
    /*
    Most important information: You are allowed to visit any city more than once (including start and finish).
    Here we are allowed to visit finish more than once so we shouldnt wait if we reach finish location instead we need to keep going untill be have fuel.
    */
   
    private final int MOD = (int) 1e9 + 7;
    
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        long [][] memo = new long[n][fuel+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], -1);
        }
        return (int) helper(start, finish, locations, fuel, memo) % MOD;
    }
    
    private long helper(int start, int end, int [] locations, int fuel, long [][] memo){
        if(fuel < 0){
            return 0;
        }
        
        if(memo[start][fuel] != -1){
            return memo[start][fuel];
        }
        
        long result = start == end ? 1 : 0;
        for(int i=0;i<locations.length;i++){
            if(i != start){
                int amountOfFuelRequired = Math.abs(locations[start]-locations[i]);
                if(amountOfFuelRequired <= fuel){
                    result = (result + helper(i, end, locations, fuel - amountOfFuelRequired, memo)) % MOD;
                }
            }
        }
        
        return memo[start][fuel] = result % MOD;
    }
}