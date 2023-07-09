class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean [] visited = new boolean[n];
        visited[0] = true;
        
        dfs(0, rooms, visited);
        
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                return false;
            } 
        }
        
        return true;
    }
    
    private void dfs(int node, List<List<Integer>> rooms, boolean [] visited){
        
        for(Integer adjNode: rooms.get(node)){
            if(!visited[adjNode]){
                visited[adjNode] = true;
                dfs(adjNode, rooms, visited);
            }
        }
    }
}