class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        // Build gragh
        for(int [] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        boolean [] visited = new boolean[n];
        long result = 0;
        int [] count = new int[1];
        long totalNodes = n;
        for(int node=0;node<n;node++){
            if(!visited[node]){
                count[0] = 0;
                int numberOfNodes = dfs(node, visited, count, list);
                totalNodes = totalNodes - numberOfNodes;
                result += (long)(numberOfNodes * totalNodes);
            }
        }

        return result;
    }

    private int dfs(int node, boolean [] visited, int [] count, List<List<Integer>> list){
        visited[node] = true;
        count[0]++;
        for(int adjNode:list.get(node)){
            if(!visited[adjNode]){
                dfs(adjNode, visited, count, list);
            }
        }

        return count[0];
    }
}