class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int [] path: connections){
            adjList.get(path[0]).add(path[1]);
            adjList.get(path[1]).add(-path[0]);
        }
        
        boolean [] visited = new boolean[n];
        
        return dfs(0, adjList, visited);
    }
    
    private int dfs(int node, List<List<Integer>> adjList, boolean [] visited){
        visited[node] = true;
        int numberOfChanges = 0;
        for(int adjNode: adjList.get(node)){
            if(!visited[Math.abs(adjNode)]){
                numberOfChanges += dfs(Math.abs(adjNode), adjList, visited) + ((adjNode > 0) ? 1 : 0);
            }
        }
        
        return numberOfChanges;
    }
}