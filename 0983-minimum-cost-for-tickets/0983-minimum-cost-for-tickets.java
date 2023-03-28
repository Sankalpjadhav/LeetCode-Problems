class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        int n = days.length;
        for(int day: days){
            set.add(day);
        }
        
        int [] memo = new int[366];
        
        Arrays.fill(memo, -1);
        
        return helper(days[n-1], set, costs, memo);
    }
    
    private int helper(int day, Set<Integer> set, int [] costs, int [] memo){
        if(day <= 0){
            return 0;
        }
        
        if(memo[day] != -1){
            return memo[day];
        }
        
        if(set.contains(day)){
            int ticket1 = costs[0] + helper(day-1, set, costs, memo);
            int ticket2 = costs[1] + helper(day-7, set, costs, memo);
            int ticket3 = costs[2] + helper(day-30, set, costs, memo);
            
            return memo[day] = Math.min(ticket1, Math.min(ticket2, ticket3));
        }
        else{
            return memo[day] = helper(day-1, set, costs, memo);
        }
    }
}


/*
Recursion: TLE
public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        int n = days.length;
        for(int day: days){
            set.add(day);
        }
        
        return helper(days[n-1], set, costs);
    }
    
    private int helper(int day, Set<Integer> set, int [] costs){
        if(day <= 0){
            return 0;
        }
        
        if(set.contains(day)){
            int ticket1 = costs[0] + helper(day-1, set, costs);
            int ticket2 = costs[1] + helper(day-7, set, costs);
            int ticket3 = costs[2] + helper(day-30, set, costs);
            
            return Math.min(ticket1, Math.min(ticket2, ticket3));
        }
        else{
            return helper(day-1, set, costs);
        }
    }
*/