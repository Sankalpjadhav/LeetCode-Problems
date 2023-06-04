class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i=0;i<n;i++)
            adj.add(new ArrayList());
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i == j)
                    continue;
                if(isConnected[i][j] == 1)
                    adj.get(i).add(j);
            }
        }
        boolean [] visited = new boolean[n];
        int ans = 0;
        
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                dfs(i, visited, adj);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int node, boolean [] visited, List<List<Integer>> list){
        visited[node] = true;
        
        for(int adjNode : list.get(node)){
            if(visited[adjNode]==false){
                dfs(adjNode, visited, list);
            }
        }
    }
}