class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int n = graph.length;
        int [] visited = new int[n];
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, n-1, graph, result, path);
        return result;
    }

    private void dfs(int node, int destination, int [][] graph, List<List<Integer>> result, List<Integer> path){
        if(node == destination){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int adjNode: graph[node]){
            path.add(adjNode);
            dfs(adjNode, destination, graph, result, path);
            path.remove(path.size()-1);
        }
    }
    
}

/*

    Tried previously: There is no need of visted array as in the question they have mentioned that the graph is directed acyclic graph i.e there wont be any cycle
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        boolean [] visited = new boolean[graph.length];
        allPaths(graph, 0, result, path, visited);
        return result;
    }
    
    public void allPaths(int[][] graph, int node, List<List<Integer>> result, List<Integer> path, boolean [] visited){
        if(node==graph.length-1){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        visited[node] = true;
        for(int nextNode: graph[node]){
            if(visited[nextNode]==false){
                path.add(nextNode);
                allPaths(graph, nextNode, result, path, visited);
                path.remove(path.size()-1);
            }
        }
        visited[node]= false;
    }

*/