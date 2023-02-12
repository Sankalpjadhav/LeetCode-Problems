class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<=roads.length;i++){
            list.add(new ArrayList<>());
        }
        
        for(int [] road : roads){
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        
        long [] cost = new long[1];
        
        dfs(0, -1, seats, cost, list);
        
        return cost[0];
    }
    
    private long dfs(int node, int parentNode, int seats, long [] cost, List<List<Integer>> list){
        
        long numberOfRepresentative = 0;
        
        for(int neighbour : list.get(node)){
            if(neighbour != parentNode){
                numberOfRepresentative += dfs(neighbour, node, seats, cost, list);
            }
        }
        
        numberOfRepresentative += 1;
        
        if(node != 0){
            cost[0] += ((numberOfRepresentative + seats)-1)/seats;
        }
        
        return numberOfRepresentative;
    }
}