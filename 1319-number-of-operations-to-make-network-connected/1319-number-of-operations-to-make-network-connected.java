class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int [] connection: connections){
            adjList.get(connection[0]).add(connection[1]);
            adjList.get(connection[1]).add(connection[0]);
        }
        
        boolean [] visited = new boolean[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, visited, adjList);
                ans++;
            }
        }
        
        return ans-1;
    }
    
    private void dfs(int node, boolean [] visited, List<List<Integer>> adjList){
        visited[node] = true;
        for(int adjNode: adjList.get(node)){
            if(!visited[adjNode]){
                dfs(adjNode, visited, adjList);
            }
        }
    }
}