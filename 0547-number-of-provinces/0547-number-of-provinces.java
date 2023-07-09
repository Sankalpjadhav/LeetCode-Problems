class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        boolean [] visited = new boolean[n];
        int numberOfProvinces = 0;
        for(int node=0;node<n;node++){
            if(!visited[node]){
                numberOfProvinces++;
                dfs(node, adjList, visited);
            }
        }
        
        return numberOfProvinces;
    }
    
    private void dfs(int node, List<List<Integer>> adjList, boolean [] visited){
        visited[node] = true;
        
        for(int adjNode: adjList.get(node)){
            if(!visited[adjNode]){
                dfs(adjNode, adjList, visited);
            }
        }
    }
}